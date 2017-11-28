package ru.gb.vtitov.weather;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ru.gb.vtitov.managers.data.ForecastSpec;
import ru.gb.vtitov.managers.data.Preferences;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements View.OnClickListener {

    public static final String FORECAST_VALUE = "forecast_value";
    public static final String ATMOSPHERE_PRESSURE = "atmosphere_pressure";
    public static final String TOMORROW_FORECAST = "tomorrow_forecast";
    public static final String NEXT_WEEK_FORECAST = "next_week_forecast";

    private final String INTENT_TYPE = "text/plain";
    private int index = 0;
    private WelcomeActivity activity;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (WelcomeActivity) context;
    }

    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view,savedInstanceState);
    }

    private void initView(View view,Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            Intent intent = activity.getIntent();
            index = intent.getIntExtra(FORECAST_VALUE,0);
        } else {
            index = savedInstanceState.getInt(FORECAST_VALUE);
        }
        String forecast = ForecastSpec.getForecast(activity,index);
        TextView textView = (TextView) view.findViewById(R.id.weather_details);
        textView.setText(forecast);
        showAtmosphereDetails();
        showTomorrowDetails();
        showNextWeekDetails();
        Button btnShare = (Button) view.findViewById(R.id.button_share);
        btnShare.setOnClickListener(this);
    }

    private void showAtmosphereDetails() {
        TextView textView = (TextView) activity.findViewById(R.id.text_atmosphere_pressure);
        textView.setText(R.string.atmosphere_preassure_placeholder);
        if (Preferences.isAtmosphere()) {
            textView.setVisibility(VISIBLE);
        } else {
            textView.setVisibility(GONE);
        }
    }

    private void showTomorrowDetails() {
        TextView textView = (TextView) activity.findViewById(R.id.text_tomorrow);
        textView.setText(R.string.tomorrow_forecast_placeholder);
        if (Preferences.isTomorrow()) {
            textView.setVisibility(VISIBLE);
        } else {
            textView.setVisibility(GONE);
        }
    }

    private void showNextWeekDetails() {
        TextView textView = (TextView) activity.findViewById(R.id.text_next_week);
        textView.setText(R.string.week_forecast_placeholder);
        if (Preferences.isNextWeek()) {
            textView.setVisibility(VISIBLE);
        } else {
            textView.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType(INTENT_TYPE);
            String title = getResources().getString(R.string.share_title);
            Intent choosenIntent = Intent.createChooser(intent,title);
            if (!activity.getPackageManager().queryIntentActivities(intent,0).isEmpty()) {
                startActivity(choosenIntent);
            } else {
                System.out.println("No support activities");
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(FORECAST_VALUE,index);
    }
}

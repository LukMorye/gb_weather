package ru.gb.vtitov.weather;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


import ru.gb.vtitov.managers.data.Preferences;
import ru.gb.vtitov.weather.city.CityAdapter;

import static android.widget.LinearLayout.VERTICAL;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {


    private WelcomeActivity activity;


    public WelcomeFragment() {
        // Required empty public constructor
    }

    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (WelcomeActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void initView(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        layoutManager.setOrientation(VERTICAL);
        RecyclerView citiesView = (RecyclerView) view.findViewById(R.id.cities_recycler_view);
        citiesView.setLayoutManager(layoutManager);
        citiesView.setAdapter(new CityAdapter(activity));
        CheckBox atmosphere = (CheckBox) view.findViewById(R.id.chBox_pressure);
        atmosphere.setChecked(Preferences.isAtmosphere());
        CheckBox tomorrow = (CheckBox) view.findViewById(R.id.chBox_tomorrow);
        tomorrow.setChecked(Preferences.isTomorrow());
        CheckBox nextWeek = (CheckBox) view.findViewById(R.id.chBox_next_week);
        nextWeek.setChecked(Preferences.isNextWeek());
    }



}

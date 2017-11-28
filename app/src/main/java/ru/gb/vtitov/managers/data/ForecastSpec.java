package ru.gb.vtitov.managers.data;

import android.content.Context;

import ru.gb.vtitov.weather.R;

/**
 * Created by valentin on 31.10.2017.
 */

public class ForecastSpec {

    public static String getForecast(Context context, int position) {
        String[] forecasts = context.getResources().getStringArray(R.array.forecast_values);
        return  forecasts[position];
    }
}

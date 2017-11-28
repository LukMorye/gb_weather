package ru.gb.vtitov.managers.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by valentin on 27.10.2017.
 */

public class Preferences {

    private static final String PREFERENCES_NAME = "WeatherSettings";
    public static final String ATMOSPHERE_PRESSURE = "atmosphere_pressure";
    public static final String TOMORROW_FORECAST = "tomorrow_forecast";
    public static final String NEXT_WEEK_FORECAST = "next_week_forecast";

    final private static String KEY_CITY = "city";
    final private static int DEF_CITY_POSITION = 0;

    private static Context context;

    public static void setContext(Context context) {
        Preferences.context = context;
    }

    public static void setCity(int cityPosition) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KEY_CITY,cityPosition);
        editor.commit();
    }

    public static int getCity() {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
        return preferences.getInt(KEY_CITY,DEF_CITY_POSITION);
    }

    public static void setIsAtmosphere(boolean isAtmosphere) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(ATMOSPHERE_PRESSURE,isAtmosphere);
        editor.commit();
    }

    public static boolean isAtmosphere() {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
        return preferences.getBoolean(ATMOSPHERE_PRESSURE,false);
    }

    public static void setIsTomorrow(boolean isTomorrow) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(TOMORROW_FORECAST,isTomorrow);
        editor.commit();
    }

    public static boolean isTomorrow() {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
        return preferences.getBoolean(TOMORROW_FORECAST,false);
    }

    public static void setIsNextWeek(boolean isNextWeek) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(NEXT_WEEK_FORECAST,isNextWeek);
        editor.commit();
    }

    public static boolean isNextWeek() {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
        return preferences.getBoolean(NEXT_WEEK_FORECAST,false);
    }
}

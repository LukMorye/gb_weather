package ru.gb.vtitov.weather;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;


import ru.gb.vtitov.managers.data.Preferences;
import ru.gb.vtitov.weather.city.CityViewHolderListener;


public class WelcomeActivity extends AppCompatActivity implements CityViewHolderListener {

    private MenuInflater inflater;

    /* App lifecycle */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Preferences.setContext(this);
        setContentView(R.layout.activity_welcome);
        Fragment fragment = WelcomeFragment.newInstance();
        presentFragment(R.id.welcome_activity,fragment,false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

    public void savePreferences(int position) {
        Preferences.setCity(position);
        Preferences.setIsAtmosphere(isAtmosphere());
        Preferences.setIsTomorrow(isTomorrow());
        Preferences.setIsNextWeek(isNextWeek());
    }

    public void presentDetailsFragment() {
        Fragment fragment = DetailFragment.newInstance();
        presentFragment(R.id.welcome_activity,fragment,true);
    }

    private void presentAddNewCityFragment() {
        Fragment fragment = AddCityFragment.newInstance();
        presentFragment(R.id.welcome_activity,fragment,true);
    }

    private boolean isAtmosphere() {
        return ((CheckBox)findViewById(R.id.chBox_pressure)).isChecked();

    }

    private boolean isTomorrow() {
        return ((CheckBox)findViewById(R.id.chBox_tomorrow)).isChecked();
    }

    private boolean isNextWeek() {
        return ((CheckBox)findViewById(R.id.chBox_next_week)).isChecked();
    }


    private void presentFragment(int containerID, Fragment fragment, boolean isPutToBackstack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(containerID,fragment);
        if (isPutToBackstack) transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClickCity(int position) {
        savePreferences(position);
        presentDetailsFragment();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_city:
                presentAddNewCityFragment();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

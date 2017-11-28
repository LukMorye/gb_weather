package ru.gb.vtitov.weather.city;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import ru.gb.vtitov.weather.R;
import ru.gb.vtitov.weather.WelcomeActivity;

/**
 * Created by valentin on 12.11.2017.
 */

public class CityAdapter extends RecyclerView.Adapter<CityViewHolder> {


    private WelcomeActivity activity;

    public CityAdapter(WelcomeActivity activity) {
        this.activity = activity;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
        CityViewHolder holder = new CityViewHolder(activity.getResources().getStringArray(R.array.cities),inflater,parent);
        holder.setListener(activity);
        return holder;
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.bind(position);
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(activity.getResources().getColor(R.color.lightGray));
        } else {
            holder.itemView.setBackgroundColor(activity.getResources().getColor(R.color.white));
        }
    }

    @Override
    public int getItemCount() {
        return activity.getResources().getStringArray(R.array.cities).length;
    }
}

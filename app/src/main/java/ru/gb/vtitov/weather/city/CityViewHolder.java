package ru.gb.vtitov.weather.city;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.gb.vtitov.weather.R;


public class CityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final String[] cities;
    private CityViewHolderListener listener;
    private TextView cityTextView;



    CityViewHolder(String[] cities,LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_city,parent,false));
        this.cities = cities;
        itemView.setOnClickListener(this);
        cityTextView = (TextView) itemView.findViewById(R.id.city_name_text_view);
    }

    void setListener(CityViewHolderListener listener) {
        this.listener = listener;
    }

    void bind(int position) {
        cityTextView.setText(cities[position]);
    }

    @Override
    public void onClick(View view) {
        listener.onClickCity(getLayoutPosition());
    }


}

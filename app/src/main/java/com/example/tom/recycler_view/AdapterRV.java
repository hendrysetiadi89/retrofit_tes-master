package com.example.tom.recycler_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tom.recycler_view.model.Weather;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tom on 1/13/2017.
 */

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.mViewHolder> {

    private List<Weather> weatherList;
    private Context context;

    public class mViewHolder extends RecyclerView.ViewHolder {
        public TextView country_name, description_weather, humidity;
        public ImageView mweather_icon;

        public mViewHolder(View view) {
            super(view);
            country_name = (TextView)view.findViewById(R.id.country_name);
            description_weather = (TextView)view.findViewById(R.id.description_weather);
            humidity = (TextView)view.findViewById(R.id.humidity);
            mweather_icon = (ImageView)view.findViewById(R.id.weather_icon);
        }
    }

    public AdapterRV(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_list_row, parent, false);
        context = parent.getContext();
        return new mViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        Weather weather = weatherList.get(position);
        holder.country_name.setText(weather.getCountry_name());
        holder.description_weather.setText(weather.getDescription_weather());
        holder.humidity.setText(weather.getHumidity());

        Picasso.with(context).load("http://openweathermap.org/img/w/" + weather.getIcon_weather()).into(holder.mweather_icon);
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

}

package com.example.lesson3_listview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by eladlavi on 13/12/2016.
 */

public class CityArrayAdapter extends ArrayAdapter<City> {


    Activity activity;
    List<City> cities;

    public CityArrayAdapter(Activity activity, List<City> cities) {
        super(activity, R.layout.item_city, cities);

        this.activity = activity;
        this.cities = cities;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_city, null);
        TextView lblCityName = (TextView)rowView.findViewById(R.id.lblCityName);
        ImageView imgCity = (ImageView)rowView.findViewById(R.id.imageCity);
        City city = cities.get(position);
        imgCity.setImageResource(city.getImage());
        lblCityName.setText(city.getName());
        return rowView;
    }
}

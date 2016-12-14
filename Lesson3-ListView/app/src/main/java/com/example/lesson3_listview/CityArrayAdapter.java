package com.example.lesson3_listview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.lesson3_listview.R.id.lblCityName;

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


    static class ViewContainer{
        TextView lblCityName;
        ImageView imgCity;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewContainer viewContainer = null;
        if(rowView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_city, null);
            viewContainer = new ViewContainer();
            viewContainer.imgCity =
                    (ImageView)rowView.findViewById(R.id.imageCity);
            viewContainer.lblCityName =
                    (TextView)rowView.findViewById(lblCityName);
            rowView.setTag(viewContainer);
            Log.d("Elad", "rowView == null " + position);
        }else{
            viewContainer = (ViewContainer) rowView.getTag();
            Log.d("Elad", "rowView != null " + position);
        }
        City city = cities.get(position);
        viewContainer.imgCity.setImageResource(city.getImage());
        viewContainer.lblCityName.setText(city.getName());
        return rowView;
    }
}

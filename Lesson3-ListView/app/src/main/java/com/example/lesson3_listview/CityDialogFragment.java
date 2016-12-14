package com.example.lesson3_listview;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by eladlavi on 14/12/2016.
 */

public class CityDialogFragment extends DialogFragment {

    private City city;
    private CityDialogListener listener;
    private EditText txtCityName;

    public void setCity(City city) {
        this.city = city;
    }

    public void setListener(CityDialogListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container);
        Button btnDone = (Button)view.findViewById(R.id.btnDone);
        txtCityName = (EditText) view.findViewById(R.id.txtCityName);
        if(city != null){
            txtCityName.setText(city.getName());
            btnDone.setText("Save");
        }else{
            btnDone.setText("Add");
        }

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = txtCityName.getText().toString();
                if(cityName.isEmpty()){
                    Toast.makeText(v.getContext(), "must enter a city name",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(city != null){
                    city.setName(cityName);
                    if(listener != null)
                        listener.cityModified();

                }else{
                    if(listener != null)
                        listener.cityAdded(cityName);
                }
                dismiss();
            }
        });
        //TODO: pop up keyboard
        return view;
    }


    interface CityDialogListener{
        void cityAdded(String cityName);
        void cityModified();
    }
}

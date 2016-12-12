package com.example.lesson2_automcomplete;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

    String[] cityNames = {
            "Tel Aviv", "Ashdod","Ashkelon",
            "Ramle", "Ramat Gan", "Givataim",
            "Ramat HaSharon", "Ra'anana", "Kfar Saba",
            "Hertselia", "Nataya", "Lod", "Tiberius",
            "Jerusalem", "Eilat", "Rosh Pina",
            "Kiryat Shmona", "Rishon Letsion",
            "Petah Tikva", "Bney Brak", "Haifa"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, cityNames);
        AutoCompleteTextView txtCity = (AutoCompleteTextView)
                findViewById(R.id.txtCity);
        txtCity.setThreshold(3);
        txtCity.setAdapter(adapter);
    }
}

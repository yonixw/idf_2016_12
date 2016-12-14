package com.example.lesson3_listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements CityDialogFragment.CityDialogListener {


    String[] cityNames = {
            "Tel Aviv", "Ashdod","Ashkelon",
            "Ramle", "Ramat Gan", "Givataim",
            "Ramat HaSharon", "Ra'anana", "Kfar Saba",
            "Hertselia", "Nataya", "Lod", "Tiberius",
            "Jerusalem", "Eilat", "Rosh Pina",
            "Kiryat Shmona", "Rishon Letsion",
            "Petah Tikva", "Bney Brak", "Haifa"
    };

    List<City> cities;

    int[] images = {R.drawable.kfar_saba, R.drawable.modieen,
            R.drawable.pic04, R.drawable.ramat_gan,
            R.drawable.rishon};
    CityArrayAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = new ArrayList<>();
        for (int i = 0; i < cityNames.length; i++) {
            City city = new City(cityNames[i], images[i%images.length]);

            cities.add(city);
        }


        listView = (ListView)findViewById(R.id.listView);
        //ArrayAdapter<City> adapter = new ArrayAdapter<City>
        //        (this, R.layout.item_city, R.id.lblCityName, cities);
        //ArrayAdapter<City> adapter = new ArrayAdapter<City>
        //        (this, android.R.layout.simple_list_item_checked,
        //                cities);

        adapter = new CityArrayAdapter(this, cities);


        listView.setAdapter(adapter);

        //listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                City city = cities.get(position);
                //city.setSelected(!city.isSelected());
                //Toast.makeText(MainActivity.this, "you have clicked " +
                //        city.getName(), Toast.LENGTH_SHORT).show();
                CityDialogFragment fragment = new CityDialogFragment();
                fragment.setListener(MainActivity.this);
                fragment.setCity(city);
                fragment.show(getFragmentManager(), "");
            }
        });


    }

    public void btnAddCity(View view) {
        CityDialogFragment fragment = new CityDialogFragment();
        fragment.setListener(this);
        fragment.show(getFragmentManager(), "");
    }

    @Override
    public void cityAdded(String cityName) {
        cities.add(new City(cityName, R.drawable.pic04));
        adapter.notifyDataSetChanged();
        listView.smoothScrollToPosition(cities.size());
    }

    @Override
    public void cityModified() {
        adapter.notifyDataSetChanged();
    }
}

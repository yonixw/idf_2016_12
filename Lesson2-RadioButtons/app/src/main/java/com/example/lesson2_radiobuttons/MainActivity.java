package com.example.lesson2_radiobuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String whoIsClicked = "";
                switch (checkedId){
                    case R.id.radio_button_1:
                        whoIsClicked = "button 1";
                        break;
                    case R.id.radio_button_2:
                        whoIsClicked = "button 2";
                        break;
                }
                Toast.makeText(MainActivity.this, whoIsClicked + " is checked.", Toast.LENGTH_SHORT).show();
            }
        });

        //radioGroup.getCheckedRadioButtonId()
    }
}

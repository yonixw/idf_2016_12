package com.example.lesson2_rankingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    CheckBox star;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout)findViewById(R.id.layout);
        for (int i = 1; i <= 5; i++) {
            star = (CheckBox)layout.findViewWithTag(String.valueOf(i));
            star.setOnClickListener(starClickListener);
        }
    }

    private View.OnClickListener starClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tag = Integer.valueOf((String)v.getTag());
            for (int i = 1; i <= 5; i++) {
                star = (CheckBox)layout.findViewWithTag(
                        String.valueOf(i));
                star.setChecked(i <= tag);
            }
        }
    };

}

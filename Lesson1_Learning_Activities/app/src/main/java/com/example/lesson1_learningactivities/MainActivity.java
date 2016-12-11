package com.example.lesson1_learningactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(this, SecondActivity.class);
        //Intent intent = new Intent("SecondActivity");
        Intent intent = new Intent();
        intent.setAction("SecondActivity");
        startActivity(Intent.createChooser(intent, "choose an app"));

    }
}

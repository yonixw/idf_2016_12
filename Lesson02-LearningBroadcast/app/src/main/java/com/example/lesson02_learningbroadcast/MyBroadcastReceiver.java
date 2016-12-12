package com.example.lesson02_learningbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by eladlavi on 12/12/2016.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        double latitude = intent.getDoubleExtra("lat", 1337.0);
        double longitude = intent.getDoubleExtra("lng", 1337.0);
        Toast.makeText(context, "received broadcast lat="+latitude
                +",lng="+longitude, Toast.LENGTH_SHORT).show();

    }
}

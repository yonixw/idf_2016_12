package com.example.lesson02_learningbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String MY_SPECIFIC_ACTION = "MY_SPECIFIC_ACTION";
    MyBroadcastReceiver broadcastReceiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastReceiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter(MY_SPECIFIC_ACTION);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    public void btnSendBroadcast(View view) {
        Intent intent = new Intent(MY_SPECIFIC_ACTION);
        intent.putExtra("lat", 34.5);
        intent.putExtra("lng", -15.5);
        sendBroadcast(intent);

    }
}

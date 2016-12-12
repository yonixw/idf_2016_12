package com.example.lesson2_homeworkactivitynavigation;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    public static final String GO_TO = "GO_TO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnGoTo2(View view) {
        goTo(2);
    }

    public void btnGoTo3(View view) {
        goTo(3);
    }

    private void goTo(int activityNumber){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(GO_TO, activityNumber);
        startActivity(intent);
    }


}

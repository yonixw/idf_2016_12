package com.example.lesson2_homeworkactivitynavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }




    private void goTo(int activityNumber){
        Intent data = new Intent();
        data.putExtra(MainActivity.GO_TO, activityNumber);
        setResult(RESULT_OK, data);
        finish();
    }

    public void btnGoTo1(View view) {
        goTo(1);
    }

    public void btnGoTo2(View view) {
        goTo(2);
    }
}

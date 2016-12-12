package com.example.lesson2_homeworkactivitynavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by eladlavi on 12/12/2016.
 */

public class SecondActivity extends Activity {

    public static final int REQUEST_CODE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int goTo = getIntent().getIntExtra(MainActivity.GO_TO, -1);
        if(goTo == 3)
            goTo3();

    }

    public void btnGoTo1(View view) {
        finish();
    }

    public void btnGoTo3(View view) {
        goTo3();
    }

    private void goTo3(){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                int goTo = data.getIntExtra(MainActivity.GO_TO, -1);
                if(goTo == 1)
                    finish();
            }
        }
    }
}

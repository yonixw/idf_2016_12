package com.example.lesson1_learningactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by eladlavi on 11/12/2016.
 */

public class SecondActivity extends Activity {

    public static final String ANSWER = "answer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(MainActivity.USER_NAME);
        int age = intent.getIntExtra(MainActivity.AGE, -1);

        Toast.makeText(this, "userName="+userName, Toast.LENGTH_LONG).show();
        Toast.makeText(this, Integer.toString(age), Toast.LENGTH_LONG).show();

        User user = (User) intent.getSerializableExtra("user");

    }

    public void btnGoBackToMainActivity(View view) {
        Intent data = new Intent();
        data.putExtra(ANSWER, 7);
        setResult(RESULT_OK, data);
        finish();
    }
}

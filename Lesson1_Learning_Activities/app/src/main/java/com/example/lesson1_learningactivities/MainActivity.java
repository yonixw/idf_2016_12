package com.example.lesson1_learningactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String USER_NAME = "userName";
    public static final String AGE = "age";
    public static final int REQUEST_CODE = 17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(this, SecondActivity.class);
        //Intent intent = new Intent("SecondActivity");
        Intent intent = new Intent();
        intent.setAction("SecondActivity");
        //intent.putExtra("userName", "eladlavi");
        //intent.putExtra("age", 35);
        Bundle extras = new Bundle();
        extras.putString(USER_NAME, "eladlavi");
        User user = new User("Elad", "Lavi", 35);
        extras.putInt(AGE, 35);
        extras.putSerializable("user", user);
        intent.putExtras(extras);
        //startActivity(Intent.createChooser(intent, "choose an app"));
        startActivityForResult(intent, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE){
            if(resultCode == RESULT_OK){
                Toast.makeText(this, "answer="+
                        data.getIntExtra(SecondActivity.ANSWER, -1),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}

package com.example.lesson2_callingbuiltapps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse("geo:32.084691, 34.800719"));
        //startActivity(intent);

        //Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(
        //        Uri.parse("market://details?id=com.zynga.livepoker"));
        //startActivity(intent);

        /*
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to = { "a@gmail.com", "b@gmail.com" };
        String[] cc = { "c@gmail.com", "d@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_CC, cc);
        intent.putExtra(Intent.EXTRA_SUBJECT, "welcome to course");
        intent.putExtra(Intent.EXTRA_TEXT, "good very good");
        intent.setType("message/rfc822");
        startActivity(intent);
        */

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        intent.putExtra(Intent.EXTRA_TEXT, "text..");
        startActivity(intent);
    }
}









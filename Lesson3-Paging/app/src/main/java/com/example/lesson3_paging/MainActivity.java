package com.example.lesson3_paging;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyPagerAdapter adapter = new MyPagerAdapter();
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
    }

    public void btnOnClick(View view){
        int tag = Integer.valueOf((String)view.getTag());
        Toast.makeText(this, "Button " + tag + " was clicked",
                Toast.LENGTH_SHORT).show();
    }
}

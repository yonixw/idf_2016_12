package com.example.lesson3_timepicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends Activity {

    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

    }

    public void btnOnClick(View view) {

        int minute = 0;
        int hour = 0;
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.M) {
            minute = timePicker.getMinute();
            hour = timePicker.getHour();
        }else{
            minute = timePicker.getCurrentMinute();
            hour = timePicker.getCurrentHour();
        }
        String time = (hour < 10 ? "0" : "") + hour + ":" +
                (minute < 10 ? "0" : "") + minute;
        //another way:
        NumberFormat formatter = new DecimalFormat("00");
        time = formatter.format(hour) + ":" + formatter.format(minute);
        Toast.makeText(this, "time selected: " + time
                , Toast.LENGTH_SHORT).show();
    }
}

package com.example.lesson2_checkboxes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox checkBox1 =
                (CheckBox)findViewById(R.id.checkbox1);
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "checkbox 1 is now " +
                        (isChecked ? "checked" : "unchecked"),
                        Toast.LENGTH_SHORT).show();
            }
        });

        int x = Integer.valueOf((String)checkBox1.getTag());
        LinearLayout linearLayout;
        linearLayout.findViewWithTag("1")
    }
}

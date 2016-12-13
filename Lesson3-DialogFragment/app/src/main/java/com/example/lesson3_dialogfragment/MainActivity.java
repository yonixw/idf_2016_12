package com.example.lesson3_dialogfragment;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements LoginDialogFragment.LoginCompletedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnShowLogin(View view) {
        LoginDialogFragment fragment = new LoginDialogFragment();
        fragment.setListener(this);
        fragment.setCancelable(false);
        fragment.show(getFragmentManager(), "");

    }

    @Override
    public void loginCompleted(String password) {
        Toast.makeText(this, "password:" + password, Toast.LENGTH_SHORT).show();
    }
}

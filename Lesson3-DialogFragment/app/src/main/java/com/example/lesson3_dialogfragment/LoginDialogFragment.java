package com.example.lesson3_dialogfragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by eladlavi on 13/12/2016.
 */

public class LoginDialogFragment extends DialogFragment {

    EditText txtPassword;
    Button btnLogin;
    LoginCompletedListener listener;

    public void setListener(LoginCompletedListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container);
        txtPassword = (EditText)view.findViewById(R.id.txtPassword);
        btnLogin = (Button)view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = txtPassword.getText().toString();
                if(password.length()>2){
                    if(listener != null)
                        listener.loginCompleted(password);
                    dismiss();
                }
            }
        });
        txtPassword.requestFocus();
        //will make the keyboard pop up
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        return view;
    }

    public interface LoginCompletedListener{
        void loginCompleted(String password);
    }

}

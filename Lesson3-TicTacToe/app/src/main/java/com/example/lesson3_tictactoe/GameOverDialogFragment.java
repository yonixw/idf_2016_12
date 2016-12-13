package com.example.lesson3_tictactoe;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by eladlavi on 13/12/2016.
 */

public class GameOverDialogFragment extends DialogFragment {

    public static final String TITLE = "title";
    GameOverListener listener;
    String title;

    public void setListener(GameOverListener listener) {
        this.listener = listener;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_over, container);
        TextView lblWinner = (TextView)view.findViewById(R.id.lblWinner);
        title = getArguments().getString(TITLE);
        lblWinner.setText(title);
        Button btnNewGame = (Button)view.findViewById(R.id.btnDone);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null)
                    listener.onGameReset();
                dismiss();
            }
        });

        return view;
    }

    public interface GameOverListener{
        void onGameReset();
    }
}

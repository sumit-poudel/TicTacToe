package com.example.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TicTacToe extends AppCompatActivity {
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

    }

    public void Click(View v) {
        TextView text = findViewById(R.id.play);
        Button button = (Button) v;
        if (count % 2 != 0) {
            text.setText("Player 1st turn");
            button.setText("X");
            button.setTextSize(50);
            button.setEnabled(false);

        } else {
            text.setText("Player 2nd turn");
            button.setText("O");
            button.setTextSize(50);
            button.setEnabled(false);
        }
        count++;
    }

    public void Reset(View v) {
        count = 0;
        TextView text=findViewById(R.id.play);
        text.setText("Play");
        ViewGroup layout = findViewById(R.id.main);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof Button && "gameButton".equals(child.getTag())) {
                ((Button) child).setText("");  // Reset button text
                ((Button)child).setEnabled(true);

            }
        }

    }
}
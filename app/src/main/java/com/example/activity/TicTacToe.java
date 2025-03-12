package com.example.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TicTacToe extends AppCompatActivity {
    int count = 1;
    int[][] logicCheck = {{0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

    }

    public void Click(View v) {
        TextView text = findViewById(R.id.play);
        Button button = (Button) v;
        String buttonID = button.getResources().getResourceEntryName(button.getId());
        int kun = Integer.parseInt(buttonID.substring(buttonID.length() - 1));

        if (count % 2 != 0) {
            text.setText("O' turn");
            button.setText("X");
            button.setTextSize(50);
            button.setEnabled(false);

        } else {
            text.setText("X's turn");
            button.setText("O");
            button.setTextSize(50);
            button.setEnabled(false);
        }
        count++;
        push(kun,button);
    }

    public void push(int kun,Button button){
        kun--;
        int row;
        int col;
        row = kun / 3;
        col = kun % 3;
        String symbol=button.getText().toString();
        if (symbol.equalsIgnoreCase("x")) logicCheck[row][col]=1;
        else logicCheck[row][col]=2;
        Toast.makeText(this,String.valueOf(logicCheck[row][col]),Toast.LENGTH_LONG).show();
    }

    public void Reset(View v) {
        count = 0;
        TextView text = findViewById(R.id.play);
        text.setText("Play");
        ViewGroup layout = findViewById(R.id.main);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof Button && "gameButton".equals(child.getTag())) {
                ((Button) child).setText("");  // Reset button text
                ((Button) child).setEnabled(true);

            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                logicCheck[i][j]=0;
            }
        }

    }
}
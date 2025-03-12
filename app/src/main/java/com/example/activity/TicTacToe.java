package com.example.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TicTacToe extends AppCompatActivity {
    int count = 1;
    String symbol = "";
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
        symbol=button.getText().toString();
        if (symbol.equalsIgnoreCase("x")) logicCheck[row][col]=1;
        else logicCheck[row][col]=2;
        check();
    }

    public void check() {
        String Symbol = symbol;
        int x, y, z, a, b, c;
        String winB1, winB2, winB3;
        Button btn1, btn2, btn3;
        for (int i = 0; i < 3; i++) {

            x = logicCheck[i][0];
            y = logicCheck[i][1];
            z = logicCheck[i][2];

            a = logicCheck[0][i];
            b = logicCheck[1][i];
            c = logicCheck[2][i];

            if (a == 1 && b == 1 && c == 1 || a == 2 && b == 2 && c == 2) {
                winB1 = "button" + (1+i);
                winB2 = "button" + (3+i+1);
                winB3 = "button" + (6+i+1);
                int buttonId1 = getResources().getIdentifier(winB1, "id", getPackageName());
                btn1 = findViewById(buttonId1);
                btn1.setTextColor(Color.RED);
                int buttonId2 = getResources().getIdentifier(winB2, "id", getPackageName());
                btn2 = findViewById(buttonId2);
                btn2.setTextColor(Color.RED);
                int buttonId3 = getResources().getIdentifier(winB3, "id", getPackageName());
                btn3 = findViewById(buttonId3);
                btn3.setTextColor(Color.RED);

                win();

            }
            if (x == 1 && y == 1 && z == 1 || x == 2 && y == 2 && z == 2) {
                winB1 = "button" + (1+(i*3));
                winB2 = "button" + (2+(i*3));
                winB3 = "button" + (3+(i*3));
                int buttonId1 = getResources().getIdentifier(winB1, "id", getPackageName());
                btn1 = findViewById(buttonId1);
                btn1.setTextColor(Color.RED);
                int buttonId2 = getResources().getIdentifier(winB2, "id", getPackageName());
                btn2 = findViewById(buttonId2);
                btn2.setTextColor(Color.RED);
                int buttonId3 = getResources().getIdentifier(winB3, "id", getPackageName());
                btn3 = findViewById(buttonId3);
                btn3.setTextColor(Color.RED);

                win();
            }

        }
        if ((logicCheck[0][0] == 1 && logicCheck[1][1] == 1 && logicCheck[2][2] == 1) || (logicCheck[0][0] == 2 && logicCheck[1][1] == 2 && logicCheck[2][2] == 2)) {
            winB1 = "button1";
            winB2 = "button5";
            winB3 = "button9";
            int buttonId1 = getResources().getIdentifier(winB1, "id", getPackageName());
            btn1 = findViewById(buttonId1);
            btn1.setTextColor(Color.RED);
            int buttonId2 = getResources().getIdentifier(winB2, "id", getPackageName());
            btn2 = findViewById(buttonId2);
            btn2.setTextColor(Color.RED);
            int buttonId3 = getResources().getIdentifier(winB3, "id", getPackageName());
            btn3 = findViewById(buttonId3);
            btn3.setTextColor(Color.RED);
            win();
        }
        if ((logicCheck[0][2] == 1 && logicCheck[1][1] == 1 && logicCheck[2][0] == 1) || (logicCheck[0][2] == 2 && logicCheck[1][1] == 2 && logicCheck[2][0] == 2)) {
            winB1 = "button3";
            winB2 = "button5";
            winB3 = "button7";
            int buttonId1 = getResources().getIdentifier(winB1, "id", getPackageName());
            btn1 = findViewById(buttonId1);
            btn1.setTextColor(Color.RED);
            int buttonId2 = getResources().getIdentifier(winB2, "id", getPackageName());
            btn2 = findViewById(buttonId2);
            btn2.setTextColor(Color.RED);
            int buttonId3 = getResources().getIdentifier(winB3, "id", getPackageName());
            btn3 = findViewById(buttonId3);
            btn3.setTextColor(Color.RED);
            win();
        }
    }
    void win(){
        TextView text = findViewById(R.id.play);
        text.setText("🥇 "+symbol + " won 🥇");

        ViewGroup layout = findViewById(R.id.main);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof Button && "gameButton".equals(child.getTag())) {
                ((Button) child).setEnabled(false);

            }
        }

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
                ((Button)child).setTextColor(Color.BLACK);

            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                logicCheck[i][j]=0;
            }
        }

    }
}
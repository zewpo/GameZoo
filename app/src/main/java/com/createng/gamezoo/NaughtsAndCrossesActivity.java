package com.createng.gamezoo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NaughtsAndCrossesActivity extends AppCompatActivity {
    boolean didWin = false;
    boolean firstPlayer = true;
    Button btnA1;
    Button btnA2;
    Button btnA3;
    Button btnB1;
    Button btnB2;
    Button btnB3;
    Button btnC1;
    Button btnC2;
    Button btnC3;
    TextView winnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naughts_and_crosses);

        btnA1 = (Button) findViewById(R.id.A1);
        btnA2 = (Button) findViewById(R.id.A2);
        btnA3 = (Button) findViewById(R.id.A3);
        btnB1 = (Button) findViewById(R.id.B1);
        btnB2 = (Button) findViewById(R.id.B2);
        btnB3 = (Button) findViewById(R.id.B3);
        btnC1 = (Button) findViewById(R.id.C1);
        btnC2 = (Button) findViewById(R.id.C2);
        btnC3 = (Button) findViewById(R.id.C3);
        winnerLabel = (TextView) findViewById(R.id.winnerLabel);
        winnerLabel.setText("First Player");
    }

    public void pushButton(View view) {
        Button pressedButton = (Button)view;
        if(!didWin && pressedButton.getText()=="") {
            pressedButton.setText(firstPlayer ? "X" : "O");
            firstPlayer = !firstPlayer;
            didSomeOneWin();
        }
    }

    public void didSomeOneWin() {
        if (   ( btnA1.getText() != "" && ( ( btnA1.getText() == btnA2.getText() && btnA2.getText() == btnA3.getText() )   // A1 - right
                                         || ( btnA1.getText() == btnB1.getText() && btnB1.getText() == btnC1.getText() )   // A1 - down
                                         || ( btnA1.getText() == btnB2.getText() && btnB2.getText() == btnC3.getText() ) ) )  // A1 - down-right diagonal
            || ( btnB1.getText() != "" && btnB1.getText() == btnB2.getText() && btnB2.getText() == btnB3.getText() ) // B1 - right
            || ( btnC1.getText() != "" && ( ( btnC1.getText() == btnC2.getText() && btnC2.getText() == btnC3.getText() ) // C1 - right
                                         || ( btnC1.getText() == btnB2.getText() && btnB2.getText() == btnA3.getText() ) ) ) // C1 - up-right
            || ( btnA2.getText() != "" && btnA2.getText() == btnB2.getText() && btnB2.getText() == btnC2.getText() ) // A2 - down
            || ( btnA3.getText() != "" && btnA3.getText() == btnB3.getText() && btnB3.getText() == btnC3.getText() ) // A3 - down
                ) {
            didWin = true;
            winnerLabel.setTextColor(Color.RED);
            winnerLabel.setText("Player " + (firstPlayer ? "O" : "X") + " Wins!");
        } else {
            winnerLabel.setText("Player " + (firstPlayer ? "X" : "O") + "'s Turn.");
        }
    }

    public void startAgain(View view) {
        btnA1.setText("");
        btnA2.setText("");
        btnA3.setText("");
        btnB1.setText("");
        btnB2.setText("");
        btnB3.setText("");
        btnC1.setText("");
        btnC2.setText("");
        btnC3.setText("");
        didWin = false;
        firstPlayer = true;
        winnerLabel.setTextColor(Color.BLACK);
        winnerLabel.setText("Player X's Turn.");
    }

}

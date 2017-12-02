package edu.towson.cdough11.finalproject_blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SetBetActivity extends AppCompatActivity {

    Button bet$1;
    Button bet$5;
    Button bet$10;
    Button bet$25;
    Button bet$50;
    Button bet$100;
    Button dealCardsButton;
    TextView betAmountTV;
    private static final int START_GAME_REQUEST_CODE = 2;
    public static int betAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_bet);
        betAmount = 0;
        bindView();
    }

    public void bindView(){
        bet$1 = (Button)findViewById(R.id.one);
        bet$5 = (Button)findViewById(R.id.five);
        bet$10 = (Button)findViewById(R.id.ten);
        bet$25 = (Button)findViewById(R.id.twentyfive);
        bet$50 = (Button)findViewById(R.id.fifty);
        bet$100 = (Button)findViewById(R.id.onehundred);
        betAmountTV = (TextView) findViewById(R.id.betAmountTV);
        dealCardsButton = (Button)findViewById(R.id.dealCardsButton);
    }



    public void onClick(View v) {
        switch(v.getId()){
            case R.id.dealCardsButton:
             // dealCardsButton.setText("Pressed");
                launchGameActivity();
                break;
            case R.id.one:
                betAmount = 1;
                betAmountTV.setText(Integer.toString(betAmount));
                break;
            case R.id.five:
                betAmount = 5;
                betAmountTV.setText(Integer.toString(betAmount));
                break;
            case R.id.ten:
                betAmount = 10;
                betAmountTV.setText(Integer.toString(betAmount));
                break;
            case R.id.twentyfive:
                betAmount = 25;
                betAmountTV.setText(Integer.toString(betAmount));
                break;
            case R.id.fifty:
                betAmount = 50;
                betAmountTV.setText(Integer.toString(betAmount));
                break;
            case R.id.onehundred:
                betAmount = 100;
                betAmountTV.setText(Integer.toString(betAmount));
                break;
        }
    }


    private void launchGameActivity() {
        Intent intent = new Intent(getBaseContext(), GameActivity.class);
        intent.putExtra("Bet Amount", betAmount);
        startActivity(intent);
    }

    public static int getBetAmount(){
        return betAmount;
    }
}

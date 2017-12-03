package edu.towson.cdough11.finalproject_blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.towson.cdough11.finalproject_blackjack.database.ProfileDataSource;

public class SetBetActivity extends AppCompatActivity {

    Button bet$1;
    Button bet$5;
    Button bet$10;
    Button bet$25;
    Button bet$50;
    Button bet$100;
    Button dealCardsButton;
    TextView betAmountTV;
    TextView currentMoney;
    private static final int START_GAME_REQUEST_CODE = 2;
    public static int betAmount;
    ProfileDataSource dataSource = ProfileDataSource.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_bet);
        betAmount = 0;
    }

    public void bindView(){
        int availableMoney = dataSource.getMoney();
        bet$1 = (Button)findViewById(R.id.one);
        if(availableMoney < 1)
            bet$1.setVisibility(View.GONE);
        else
            bet$1.setVisibility(View.VISIBLE);
        bet$5 = (Button)findViewById(R.id.five);
        if(availableMoney < 5)
            bet$5.setVisibility(View.GONE);
        else
            bet$5.setVisibility(View.VISIBLE);
        bet$10 = (Button)findViewById(R.id.ten);
        if(availableMoney < 10)
            bet$10.setVisibility(View.GONE);
        else
            bet$10.setVisibility(View.VISIBLE);
        bet$25 = (Button)findViewById(R.id.twentyfive);
        if(availableMoney < 25)
            bet$25.setVisibility(View.GONE);
        else
            bet$25.setVisibility(View.VISIBLE);
        bet$50 = (Button)findViewById(R.id.fifty);
        if(availableMoney < 50)
            bet$50.setVisibility(View.GONE);
        else
            bet$50.setVisibility(View.VISIBLE);
        bet$100 = (Button)findViewById(R.id.onehundred);
        if(availableMoney < 100)
            bet$100.setVisibility(View.GONE);
        else
            bet$100.setVisibility(View.VISIBLE);
        betAmountTV = (TextView) findViewById(R.id.betAmountTV);
        dealCardsButton = (Button)findViewById(R.id.dealCardsButton);
        currentMoney = (TextView)findViewById(R.id.currentMoney);
        currentMoney.setText("$" + availableMoney);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindView();
    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.dealCardsButton:
                launchGameActivity();
                break;
            case R.id.one:
                betAmount = 1;
                betAmountTV.setText("$" + Integer.toString(betAmount));
                break;
            case R.id.five:
                betAmount = 5;
                betAmountTV.setText("$" + Integer.toString(betAmount));
                break;
            case R.id.ten:
                betAmount = 10;
                betAmountTV.setText("$" + Integer.toString(betAmount));
                break;
            case R.id.twentyfive:
                betAmount = 25;
                betAmountTV.setText("$" + Integer.toString(betAmount));
                break;
            case R.id.fifty:
                betAmount = 50;
                betAmountTV.setText("$" + Integer.toString(betAmount));
                break;
            case R.id.onehundred:
                betAmount = 100;
                betAmountTV.setText("$" + Integer.toString(betAmount));
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

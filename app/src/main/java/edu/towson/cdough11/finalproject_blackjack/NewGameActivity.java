package edu.towson.cdough11.finalproject_blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

public class NewGameActivity extends AppCompatActivity {

    Spinner betAmounts;
    Button deal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        bindView();
    }

    public void bindView(){
        betAmounts = (Spinner)findViewById(R.id.betAmounts);
        deal = (Button)findViewById(R.id.dealCards);
    }
}

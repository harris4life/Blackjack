package edu.towson.cdough11.finalproject_blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class SetBetActivity extends AppCompatActivity {

    Spinner betAmounts;
    Button dealCardsButton;
    private static final int START_GAME_REQUEST_CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_bet);
        bindView();
    }

    public void bindView(){
        betAmounts = (Spinner)findViewById(R.id.betAmounts);
        dealCardsButton = (Button)findViewById(R.id.dealCardsButton);
    }



    public void onClick(View v) {
        switch(v.getId()){
            case R.id.dealCardsButton:
             // dealCardsButton.setText("Pressed");
                launchGameActivity();
                break;
        }
    }


    private void launchGameActivity() {
        Intent intent = new Intent(getBaseContext(), Game.class);
        startActivity(intent);
    }

}

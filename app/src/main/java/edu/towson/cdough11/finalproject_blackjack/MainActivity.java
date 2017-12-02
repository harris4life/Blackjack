package edu.towson.cdough11.finalproject_blackjack;

import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int START_GAME_REQUEST_CODE = 2;
    private static final int DISPLAY_RULES_REQUEST_CODE = 3;
    Button startBtn;
    Button howToPlayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
    }

    public void bindView(){
        startBtn = (Button)findViewById(R.id.startBtn);
        howToPlayBtn = (Button)findViewById(R.id.rules);
        startBtn.setOnClickListener(this);
        howToPlayBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.startBtn:
                launchStartGameActivity();
                break;
            case R.id.rules:
                launchDisplayRulesActivity();
                break;
        }
    }

    private void launchDisplayRulesActivity() {
        Intent intent = new Intent(getBaseContext(), RulesActivity.class);
        startActivityForResult(intent, DISPLAY_RULES_REQUEST_CODE);
    }

    private void launchStartGameActivity() {
        Intent intent = new Intent(getBaseContext(), SetBetActivity.class);
        startActivityForResult(intent, START_GAME_REQUEST_CODE);
    }
}
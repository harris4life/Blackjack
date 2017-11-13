package edu.towson.cdough11.finalproject_blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int START_GAME_REQUEST_CODE = 2;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
    }

    public void bindView(){
        startBtn = (Button)findViewById(R.id.startBtn);
        startBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.startBtn:
                launchStartGameActivity();
                break;
        }
    }

    private void launchStartGameActivity() {
        Intent intent = new Intent(getBaseContext(), SetBetActivity.class);
        startActivityForResult(intent, START_GAME_REQUEST_CODE);
    }
}
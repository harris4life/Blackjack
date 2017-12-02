package edu.towson.cdough11.finalproject_blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import edu.towson.cdough11.finalproject_blackjack.Models.Card;
import edu.towson.cdough11.finalproject_blackjack.Models.Game;

public class GameActivity extends AppCompatActivity implements IView, View.OnClickListener {

    RecyclerView recyclerview;
    CardsAdapter adapter;
    IPresenter presenter;
    Button hit;
    Button stay;
    TextView handResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this, new Game());
        setContentView(R.layout.activity_game);
        presenter.dealCards();
        adapter = new CardsAdapter(presenter.getPlayerHand());
        bindView();
        refresh();
    }

    private void bindView() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(layoutManager);
        hit = (Button)findViewById(R.id.hit);
        stay = (Button)findViewById(R.id.stay);
        hit.setOnClickListener(this);
        stay.setOnClickListener(this);
        handResult = (TextView)findViewById(R.id.handResult);
    }

    public void refresh(){
        adapter.notifyDataSetChanged();
        return;
    }

    @Override
    public void showFinalSum(int sum, boolean blackjack) {
        hit.setVisibility(View.GONE);
        stay.setVisibility(View.GONE);
        if(sum > 21)
            handResult.setText("BUST!");
        else if(blackjack)
            handResult.setText("BLACKJACK!");
        else
            handResult.setText("Hand value: " + sum);
        handResult.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.hit:
                presenter.hit();
                break;
            case R.id.stay:
                presenter.stay();
                break;
        }
    }
}


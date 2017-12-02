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
    RecyclerView dealerRecyclerView;
    CardsAdapter adapter;
    CardsAdapter dealerAdapter;
    IPresenter presenter;
    Button hit;
    Button stay;
    TextView handResult;
    int playerSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this, new Game());
        setContentView(R.layout.activity_game);
        adapter = new CardsAdapter(presenter.getPlayerHand());
        dealerAdapter = new CardsAdapter(presenter.getDealerHand());
        bindView();
        presenter.dealCards();
        dealerAdapter.hideCardValues();
    }

    private void bindView() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager dealerLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(layoutManager);
        dealerRecyclerView = (RecyclerView)findViewById(R.id.dealerRecyclerView);
        dealerRecyclerView.setAdapter(dealerAdapter);
        dealerRecyclerView.setLayoutManager(dealerLayoutManager);
        hit = (Button)findViewById(R.id.hit);
        stay = (Button)findViewById(R.id.stay);
        hit.setOnClickListener(this);
        stay.setOnClickListener(this);
        handResult = (TextView)findViewById(R.id.handResult);
    }

    public void refresh(){
        adapter.notifyDataSetChanged();
        dealerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFinalSum(int sum, boolean blackjack) {
        playerSum = sum;
        hit.setVisibility(View.GONE);
        stay.setVisibility(View.GONE);
        if(sum > 21)
            handResult.setText("BUST!");
        else if(blackjack)
            handResult.setText("BLACKJACK! You won $X");
        else
            handResult.setText("Hand value: " + sum);
        handResult.setVisibility(View.VISIBLE);
        dealerAdapter.showCardValues();
        if(!blackjack)
            presenter.processDealerHand();
    }

    @Override
    public void showWhoWon(int dealerSum, boolean dealerBlackjack) {
        if(dealerBlackjack){
            handResult.setText("Dealer BlackJack. You lost $X");
        }
        else if(playerSum > 21){
            handResult.setText("BUST! You lost $X.");
        }
        else if(dealerSum > 21){
            handResult.setText("DEALER BUST! You won $X");
        }
        else if(dealerSum > playerSum){
            handResult.setText("Dealer had " + dealerSum + ", you had " + playerSum + ", you lose $X");
        }
        else if (playerSum > dealerSum){
            handResult.setText("Dealer had " + dealerSum + ", you had " + playerSum + ", you win $X");
        }
        else {
            handResult.setText("Dealer had " + dealerSum + ", you had " + playerSum + ", push.");
        }
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


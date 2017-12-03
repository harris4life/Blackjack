package edu.towson.cdough11.finalproject_blackjack;

import android.content.Intent;
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
import edu.towson.cdough11.finalproject_blackjack.database.ProfileDataSource;
import edu.towson.cdough11.finalproject_blackjack.services.IntentService;

public class GameActivity extends AppCompatActivity implements IView, View.OnClickListener {

    RecyclerView recyclerview;
    RecyclerView dealerRecyclerView;
    CardsAdapter adapter;
    CardsAdapter dealerAdapter;
    IPresenter presenter;
    String gameResult;
    Button hit;
    Button stay;
    TextView handResult;
    int playerSum;
    int bet;
    ProfileDataSource dataSource;
    int currentMoney;
    TextView currentMoneyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent betIntent = getIntent();
        dataSource = ProfileDataSource.getInstance(this);
        currentMoney = dataSource.getMoney();
        bet = betIntent.getIntExtra("Bet Amount", 1);
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
        currentMoneyText = (TextView)findViewById(R.id.gameCurrentMoney);
        currentMoneyText.setText("Current Money: $" + dataSource.getMoney());
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
        else if(blackjack) {
            handResult.setText("BLACKJACK! You won $" + bet * 2);
            dataSource.updateMoney(currentMoney + (2 *bet));
            gameResult = "won";
        }
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
            handResult.setText("Dealer BlackJack. You lost $" + bet*2);
            gameResult = "lose";
            if(!(bet * 2 > currentMoney))
                dataSource.updateMoney(currentMoney - (bet * 2));
            else
                dataSource.updateMoney(0);
        }
        else if(playerSum > 21){
            handResult.setText("BUST! You lost $" + bet);
            dataSource.updateMoney(currentMoney - bet);
            gameResult = "lose";
        }
        else if(dealerSum > 21){
            handResult.setText("DEALER BUST! You won $" + bet);
            dataSource.updateMoney(currentMoney + bet);
            gameResult = "won";
        }
        else if(dealerSum > playerSum){
            handResult.setText("Dealer had " + dealerSum + ", you had " + playerSum + ", you lose $" + bet);
            dataSource.updateMoney(currentMoney - bet);
            gameResult = "lose";
        }
        else if (playerSum > dealerSum){
            handResult.setText("Dealer had " + dealerSum + ", you had " + playerSum + ", you won $" + bet);
            dataSource.updateMoney(currentMoney + bet);
            gameResult = "won";

        }
        else {
            handResult.setText("Dealer had " + dealerSum + ", you had " + playerSum + ", push.");
            gameResult = "push";
        }
        Intent intent = new Intent(this, IntentService.class);
        intent.putExtra("result", gameResult);
        startService(intent);
        currentMoneyText.setText("Current Money: $" + dataSource.getMoney());
        startService(new Intent(this, IntentService.class));
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


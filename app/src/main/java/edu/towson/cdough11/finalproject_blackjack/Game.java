package edu.towson.cdough11.finalproject_blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import edu.towson.cdough11.finalproject_blackjack.Models.Card;

public class Game extends AppCompatActivity {

    RecyclerView recyclerview;
    CardsAdapter adapter;
    List<Card> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        bindView();
    }

    private void bindView() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerview.setLayoutManager(layoutManager);
        adapter = new CardsAdapter(cards);
        recyclerview.setAdapter(adapter);
    }
}


package edu.towson.cdough11.finalproject_blackjack;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.towson.cdough11.finalproject_blackjack.Models.Card;

/**
 * Created by tsuba on 11/12/2017.
 */

    public class CardsAdapter extends RecyclerView.Adapter<CardViewHolder> {

        List<Card> cards;

        public CardsAdapter(List<Card> cards){
            this.cards = cards;
        }

        @Override
        public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.card_view, parent, false);
            CardViewHolder vh = new CardViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(CardViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

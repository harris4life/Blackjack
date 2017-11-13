package edu.towson.cdough11.finalproject_blackjack.Models;

import android.graphics.drawable.Drawable;

/**
 * Created by Sips Tea on 10/22/2017.
 */

public class Card {

    private String suit;

    private String rank;

    private Drawable image;

    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }



}

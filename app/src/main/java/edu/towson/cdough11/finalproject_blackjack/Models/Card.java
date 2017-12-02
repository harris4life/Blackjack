package edu.towson.cdough11.finalproject_blackjack.Models;

import edu.towson.cdough11.finalproject_blackjack.R;

/**
 * Created by Sips Tea on 10/22/2017.
 */

public class Card {

    private String suit;

    private String rank;

    private int imageID;

    private int previousImageID;

    public static final int CARD_BACK_ID = R.drawable.deck2;

    public Card(String rank, String suit, int imageID){
        this.rank = rank;
        this.suit = suit;
        this.imageID = imageID;
        previousImageID = imageID;
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

    public int getImageID() {
        return imageID;
    }

    public void showCardBack(){
        previousImageID = imageID;
        imageID = CARD_BACK_ID;
    }

    public void revealCard(){
        imageID = previousImageID;
    }
}

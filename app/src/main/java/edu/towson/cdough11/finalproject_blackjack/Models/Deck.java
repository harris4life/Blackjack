package edu.towson.cdough11.finalproject_blackjack.Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.towson.cdough11.finalproject_blackjack.R;

/**
 * Created by Sips Tea on 10/22/2017.
 */

public class Deck {

    List<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        if(!deck.isEmpty())
            deck.clear();

        deck.add(new Card("A", "Hearts", R.drawable.ace_of_hearts));
        deck.add(new Card("2", "Hearts", R.drawable.two_of_hearts));
        deck.add(new Card("3", "Hearts", R.drawable.three_of_hearts));
        deck.add(new Card("4", "Hearts", R.drawable.four_of_hearts));
        deck.add(new Card("5", "Hearts", R.drawable.five_of_hearts));
        deck.add(new Card("6", "Hearts", R.drawable.six_of_hearts));
        deck.add(new Card("7", "Hearts", R.drawable.seven_of_hearts));
        deck.add(new Card("8", "Hearts", R.drawable.eight_of_hearts));
        deck.add(new Card("9", "Hearts", R.drawable.nine_of_hearts));
        deck.add(new Card("10", "Hearts", R.drawable.ten_of_hearts));
        deck.add(new Card("J", "Hearts", R.drawable.jack_of_hearts));
        deck.add(new Card("Q", "Hearts", R.drawable.queen_of_hearts));
        deck.add(new Card("K", "Hearts", R.drawable.king_of_hearts));

        deck.add(new Card("A", "Clubs", R.drawable.ace_of_clubs));
        deck.add(new Card("2", "Clubs", R.drawable.two_of_clubs));
        deck.add(new Card("3", "Clubs", R.drawable.three_of_clubs));
        deck.add(new Card("4", "Clubs", R.drawable.four_of_clubs));
        deck.add(new Card("5", "Clubs", R.drawable.five_of_clubs));
        deck.add(new Card("6", "Clubs", R.drawable.six_of_clubs));
        deck.add(new Card("7", "Clubs", R.drawable.seven_of_clubs));
        deck.add(new Card("8", "Clubs", R.drawable.eight_of_clubs));
        deck.add(new Card("9", "Clubs", R.drawable.nine_of_clubs));
        deck.add(new Card("10", "Clubs", R.drawable.ten_of_clubs));
        deck.add(new Card("J", "Clubs", R.drawable.jack_of_clubs));
        deck.add(new Card("Q", "Clubs", R.drawable.queen_of_clubs));
        deck.add(new Card("K", "Clubs", R.drawable.king_of_clubs));

        deck.add(new Card("A", "Spades", R.drawable.ace_of_spades));
        deck.add(new Card("2", "Spades", R.drawable.two_of_spades));
        deck.add(new Card("3", "Spades", R.drawable.three_of_spades));
        deck.add(new Card("4", "Spades", R.drawable.four_of_spades));
        deck.add(new Card("5", "Spades", R.drawable.five_of_spades));
        deck.add(new Card("6", "Spades", R.drawable.six_of_spades));
        deck.add(new Card("7", "Spades", R.drawable.seven_of_spades));
        deck.add(new Card("8", "Spades", R.drawable.eight_of_spades));
        deck.add(new Card("9", "Spades", R.drawable.nine_of_spades));
        deck.add(new Card("10", "Spades", R.drawable.ten_of_spades));
        deck.add(new Card("J", "Spades", R.drawable.jack_of_spades));
        deck.add(new Card("Q", "Spades", R.drawable.queen_of_spades));
        deck.add(new Card("K", "Spades", R.drawable.king_of_spades));

        deck.add(new Card("A", "Diamonds", R.drawable.ace_of_diamonds));
        deck.add(new Card("2", "Diamonds", R.drawable.two_of_diamonds));
        deck.add(new Card("3", "Diamonds", R.drawable.three_of_diamonds));
        deck.add(new Card("4", "Diamonds", R.drawable.four_of_diamonds));
        deck.add(new Card("5", "Diamonds", R.drawable.five_of_diamonds));
        deck.add(new Card("6", "Diamonds", R.drawable.six_of_diamonds));
        deck.add(new Card("7", "Diamonds", R.drawable.seven_of_diamonds));
        deck.add(new Card("8", "Diamonds", R.drawable.eight_of_diamonds));
        deck.add(new Card("9", "Diamonds", R.drawable.nine_of_diamonds));
        deck.add(new Card("10", "Diamonds", R.drawable.ten_of_diamonds));
        deck.add(new Card("J", "Diamonds", R.drawable.jack_of_diamonds));
        deck.add(new Card("Q", "Diamonds", R.drawable.queen_of_diamonds));
        deck.add(new Card("K", "Diamonds", R.drawable.king_of_diamonds));
    }

    private void shuffle(){
        if(deck.size() < 52) {
            initializeDeck();
        }
        Collections.shuffle(deck);
    }

    public Card draw() {
        return deck.remove(0);
    }
}

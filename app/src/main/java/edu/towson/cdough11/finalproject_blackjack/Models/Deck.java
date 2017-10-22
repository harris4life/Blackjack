package edu.towson.cdough11.finalproject_blackjack.Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        deck.add(new Card("A", "Hearts"));
        deck.add(new Card("2", "Hearts"));
        deck.add(new Card("3", "Hearts"));
        deck.add(new Card("4", "Hearts"));
        deck.add(new Card("5", "Hearts"));
        deck.add(new Card("6", "Hearts"));
        deck.add(new Card("7", "Hearts"));
        deck.add(new Card("8", "Hearts"));
        deck.add(new Card("9", "Hearts"));
        deck.add(new Card("10", "Hearts"));
        deck.add(new Card("J", "Hearts"));
        deck.add(new Card("Q", "Hearts"));
        deck.add(new Card("K", "Hearts"));

        deck.add(new Card("A", "Clubs"));
        deck.add(new Card("2", "Clubs"));
        deck.add(new Card("3", "Clubs"));
        deck.add(new Card("4", "Clubs"));
        deck.add(new Card("5", "Clubs"));
        deck.add(new Card("6", "Clubs"));
        deck.add(new Card("7", "Clubs"));
        deck.add(new Card("8", "Clubs"));
        deck.add(new Card("9", "Clubs"));
        deck.add(new Card("10", "Clubs"));
        deck.add(new Card("J", "Clubs"));
        deck.add(new Card("Q", "Clubs"));
        deck.add(new Card("K", "Clubs"));

        deck.add(new Card("A", "Spades"));
        deck.add(new Card("2", "Spades"));
        deck.add(new Card("3", "Spades"));
        deck.add(new Card("4", "Spades"));
        deck.add(new Card("5", "Spades"));
        deck.add(new Card("6", "Spades"));
        deck.add(new Card("7", "Spades"));
        deck.add(new Card("8", "Spades"));
        deck.add(new Card("9", "Spades"));
        deck.add(new Card("10", "Spades"));
        deck.add(new Card("J", "Spades"));
        deck.add(new Card("Q", "Spades"));
        deck.add(new Card("K", "Spades"));

        deck.add(new Card("A", "Diamonds"));
        deck.add(new Card("2", "Diamonds"));
        deck.add(new Card("3", "Diamonds"));
        deck.add(new Card("4", "Diamonds"));
        deck.add(new Card("5", "Diamonds"));
        deck.add(new Card("6", "Diamonds"));
        deck.add(new Card("7", "Diamonds"));
        deck.add(new Card("8", "Diamonds"));
        deck.add(new Card("9", "Diamonds"));
        deck.add(new Card("10", "Diamonds"));
        deck.add(new Card("J", "Diamonds"));
        deck.add(new Card("Q", "Diamonds"));
        deck.add(new Card("K", "Diamonds"));
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

package edu.towson.cdough11.finalproject_blackjack.Models;

/**
 * Created by Sips Tea on 10/22/2017.
 */

public class Game implements IModel {

    Player player;
    Dealer dealer;
    Deck deck;
    int bet;

    public Game(){
        player = new Player();
        dealer = new Dealer();
        deck = new Deck();
    }

    @Override
    public void dealGame() {
        player.draw(deck.draw());
        dealer.draw(deck.draw());
        player.draw(deck.draw());
        dealer.draw(deck.draw());
        boolean playerBlackjack = player.checkBlackjack();
        boolean dealerBlackjack = dealer.checkBlackjack();
        if(playerBlackjack && dealerBlackjack)
            push();
        else if (playerBlackjack)
            playerWin(true);
        else if (dealerBlackjack)
            dealerWin(true);
    }

    @Override
    public void placeBet(int bet) {
        this.bet = bet;
    }

    @Override
    public void dealerWin(boolean blackjack) {

    }

    @Override
    public void playerWin(boolean blackjack) {

    }

    @Override
    public void push() {

    }

    @Override
    public void dealerHit() {
        dealer.hit(deck.draw());
    }

    @Override
    public void playerHit() {
        player.hit(deck.draw());
    }
}

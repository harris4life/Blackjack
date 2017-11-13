package edu.towson.cdough11.finalproject_blackjack.Models;

import java.util.List;

import edu.towson.cdough11.finalproject_blackjack.IPresenter;

/**
 * Created by Sips Tea on 10/22/2017.
 */

public class Game implements IModel {

    IPresenter presenter;

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
        if(blackjack)
            presenter.showFinalSum(21, true);
    }

    @Override
    public void push() {

    }

    @Override
    public void dealerHit() {
        dealer.hit(deck.draw());
    }

    @Override
    public int dealerStay() {
        return 0;
    }

    @Override
    public void dealerBust() {
        dealerStay();
    }

    @Override
    public void playerHit() {
        player.hit(deck.draw());
        if(player.busted())
            playerBust();
    }

    @Override
    public int playerStay() {
        player.stay();
        return player.finalSum;
    }

    @Override
    public void playerBust() {
        presenter.stay();
    }


    @Override
    public List<Card> getPlayerHand() {
        return player.hand;
    }

    @Override
    public List<Card> getDealerHand() {
        return dealer.hand;
    }

    @Override
    public void setPresenter(IPresenter presenter) {
        this.presenter= presenter;
    }
}

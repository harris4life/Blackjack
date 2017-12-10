package edu.towson.cdough11.finalproject_blackjack.Models;

import android.os.AsyncTask;

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
        List<Card> dealerHand = getDealerHand();
        //dealerHand.get(0).setRank("10");
        //dealerHand.get(1).setRank("A");
        boolean playerBlackjack = player.checkBlackjack();
        boolean dealerBlackjack = dealer.checkBlackjack();
        if(playerBlackjack && dealerBlackjack)
            pushOnDoubleBlackjack();
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
        if(blackjack) {
            presenter.showFinalSum(player.getHandSum());
            presenter.showWhoWon(21, true);
        }

    }

    @Override
    public void playerWin(boolean blackjack) {
        if(blackjack)
            presenter.showFinalSum(21, true);
    }

    @Override
    public void pushOnDoubleBlackjack() {
        player.stay();
        processDealerHand();
    }

    @Override
    public void processDealerHand() {
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                presenter.showWhoWon(dealerStay(), false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                if(dealer.getHandSum() >= 17)
                    dealer.stay();
                else {
                    while (!dealer.hasStayed() && !dealer.busted()) {
                        dealer.hit(deck.draw());
                        publishProgress();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                publishProgress();
                return null;
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
                presenter.refresh();
            }
        };
        task.execute();
    }

    @Override
    public void dealerHit() {
        dealer.hit(deck.draw());
        if(dealer.busted())
            dealerBust();
    }

    @Override
    public int dealerStay() {
        dealer.stay();
        return dealer.getFinalSum();
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
    public int getPlayerHandSum(){
        return player.getHandSum();
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

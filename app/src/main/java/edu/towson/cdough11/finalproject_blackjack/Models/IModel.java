package edu.towson.cdough11.finalproject_blackjack.Models;

import java.util.List;

import edu.towson.cdough11.finalproject_blackjack.IPresenter;

/**
 * Created by Sips Tea on 10/22/2017.
 */

public interface IModel {

    public void dealGame();
    public void placeBet(int bet);
    public void dealerWin(boolean blackjack);
    public void playerWin(boolean blackjack);
    public void push();
    public void dealerHit();
    public int dealerStay();
    public void dealerBust();
    public void playerHit();
    public int playerStay();
    public void playerBust();
    List<Card> getPlayerHand();
    List<Card> getDealerHand();
    public void setPresenter(IPresenter presenter);
}

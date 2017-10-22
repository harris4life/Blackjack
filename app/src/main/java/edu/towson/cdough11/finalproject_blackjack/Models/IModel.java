package edu.towson.cdough11.finalproject_blackjack.Models;

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
    public void playerHit();
}

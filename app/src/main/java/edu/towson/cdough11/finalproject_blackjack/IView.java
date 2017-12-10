package edu.towson.cdough11.finalproject_blackjack;

/**
 * Created by Sips Tea on 11/13/2017.
 */

public interface IView {

    void refresh();
    void showFinalSum(int sum, boolean blackjack);
    void showFinalSum(int sum);
    void showWhoWon(int sum, boolean blackjack);
    void updatePlayerHandSum(int sum);
}

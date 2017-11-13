package edu.towson.cdough11.finalproject_blackjack;

import java.util.List;

import edu.towson.cdough11.finalproject_blackjack.Models.Card;

/**
 * Created by Sips Tea on 11/13/2017.
 */

public interface IPresenter {

    void dealCards();
    List<Card> getPlayerHand();
    List<Card> getDealerHand();
    void hit();;
    void stay();
    void showFinalSum(int sum, boolean blackjack);

}

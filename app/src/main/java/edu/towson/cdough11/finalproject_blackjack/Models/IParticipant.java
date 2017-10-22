package edu.towson.cdough11.finalproject_blackjack.Models;

/**
 * Created by Sips Tea on 10/22/2017.
 */

public interface IParticipant {

    public void hit(Card card);
    public void stay();
    public void draw(Card card);
    public boolean checkBlackjack();
    public int getHandSum();
    public void bust();
    public boolean busted();
    public int getFinalSum();
    public boolean hasStayed();
}

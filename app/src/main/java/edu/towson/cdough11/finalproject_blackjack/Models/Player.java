package edu.towson.cdough11.finalproject_blackjack.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sips Tea on 10/22/2017.
 */

public class Player implements IParticipant {

    List<Card> hand;
    private boolean bust;
    private boolean stay;
    public int finalSum;

    public Player(){
        hand = new ArrayList<Card>();
    }

    @Override
    public void hit(Card card) {
        draw(card);
        int sum = getHandSum();
        if(getHandSum() == 21)
            stay();
        else if(getHandSum() > 21)
            bust();
    }

    @Override
    public void stay() {
        stay = true;
        finalSum = getHandSum();
    }

    @Override
    public void draw(Card card) {
        hand.add(card);
    }

    @Override
    public boolean checkBlackjack() {
        return getHandSum() == 21;
    }

    @Override
    public int getHandSum() {
        List<Integer> possibleSums = new ArrayList<Integer>();
        int numberOfAces = 0;
        int sumOfConstants = 0;
        for(Card card: hand){
            if(card.getRank().equals("J") || card.getRank().equals("Q") || card.getRank().equals("K"))
                sumOfConstants += 10;
            else if(card.getRank().equals("A"))
                numberOfAces++;
            else
                sumOfConstants += Integer.parseInt(card.getRank());
        }

        if(numberOfAces == 0)
            possibleSums.add(sumOfConstants);
        else if(numberOfAces == 1) {
            possibleSums.add(sumOfConstants + 1);
            possibleSums.add(sumOfConstants + 11);
        }
        else if(numberOfAces == 2) {
            possibleSums.add(sumOfConstants + 2);
            possibleSums.add(sumOfConstants + 22);
            possibleSums.add(sumOfConstants + 12);
        }
        else if(numberOfAces == 3) {
            possibleSums.add(sumOfConstants + 3);
            possibleSums.add(sumOfConstants + 33);
            possibleSums.add(sumOfConstants + 13);
            possibleSums.add(sumOfConstants + 23);
        }
        else if(numberOfAces == 4) {
            possibleSums.add(sumOfConstants + 4);
            possibleSums.add(sumOfConstants + 14);
            possibleSums.add(sumOfConstants + 24);
            possibleSums.add(sumOfConstants + 34);
            possibleSums.add(sumOfConstants + 44);
        }

        boolean allGreaterThan21 = true;
        boolean has21 = false;


        for(Integer i: possibleSums){
            if(i < 21)
                allGreaterThan21 = false;
            if(i == 21)
                return 21;
        }

        if(allGreaterThan21)
            return possibleSums.get(0);
        else
            return getClosestSumTo21(possibleSums);
    }

    private int getClosestSumTo21(List<Integer> possibleSums) {
        int bestSum = -1;
        for(int sum: possibleSums){
            int difference = 21 - sum;
            if(difference == 0)
                return 21;
            else if(difference > 0)
                if(sum > bestSum)
                    bestSum = sum;
        }

        return bestSum;
    }

    @Override
    public void bust() {
        bust = true;
    }

    @Override
    public boolean busted() {
        return bust;
    }

    @Override
    public int getFinalSum() {
        return finalSum;
    }

    @Override
    public boolean hasStayed() {
        return stay;
    }


}

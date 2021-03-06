package edu.towson.cdough11.finalproject_blackjack;

import android.app.IntentService;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import edu.towson.cdough11.finalproject_blackjack.Models.Card;
import edu.towson.cdough11.finalproject_blackjack.Models.IModel;

/**
 * Created by Sips Tea on 11/13/2017.
 */

public class MainPresenter implements IPresenter {

    private final IModel model;
    private WeakReference<IView> view;
    private int currentPlayerSum;

    public MainPresenter(IView view, IModel model){
        this.view = new WeakReference<IView>(view);
        this.model = model;
        model.setPresenter(this);
        currentPlayerSum = 0;
    }

    @Override
    public void dealCards(){
        model.dealGame();
        currentPlayerSum = model.getPlayerHandSum();
        IView viewRef = view.get();
        if(viewRef != null)
            viewRef.updatePlayerHandSum(currentPlayerSum);
    }

    @Override
    public List<Card> getPlayerHand() {
        return model.getPlayerHand();
    }

    @Override
    public List<Card> getDealerHand() {
        return model.getDealerHand();
    }

    @Override
    public void hit() {
        model.playerHit();
        currentPlayerSum = model.getPlayerHandSum();
        IView viewRef = view.get();
        if(viewRef != null) {
            viewRef.refresh();
            viewRef.updatePlayerHandSum(currentPlayerSum);
        }
    }

    @Override
    public int getPlayerHandSum(){
        return currentPlayerSum;
    }

    @Override
    public void stay() {
        int finalSum = model.playerStay();
        showFinalSum(finalSum, false);
    }

    @Override
    public void showFinalSum(int sum, boolean blackjack) {
        IView viewRef = view.get();
        if(viewRef != null)
            viewRef.showFinalSum(sum, blackjack);
    }

    public void showFinalSum(int sum) {
        IView viewRef = view.get();
        if(viewRef != null)
            viewRef.showFinalSum(sum);
    }

    @Override
    public void showWhoWon(int sum, boolean dealerBlackjack) {
        IView viewRef = view.get();
        if(viewRef != null)
            viewRef.showWhoWon(sum, dealerBlackjack);
    }

    @Override
    public void processDealerHand() {
        model.processDealerHand();
    }

    @Override
    public void refresh() {
        IView viewRef = view.get();
        if(viewRef != null)
            viewRef.refresh();
    }
}

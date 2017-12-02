package edu.towson.cdough11.finalproject_blackjack;

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

    public MainPresenter(IView view, IModel model){
        this.view = new WeakReference<IView>(view);
        this.model = model;
        model.setPresenter(this);
    }

    @Override
    public void dealCards(){
        model.dealGame();
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
        IView viewRef = view.get();
        if(viewRef != null)
            viewRef.refresh();
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

package edu.towson.cdough11.finalproject_blackjack;

import org.junit.Test;
import org.mockito.Mockito;

import edu.towson.cdough11.finalproject_blackjack.Models.Game;
import edu.towson.cdough11.finalproject_blackjack.Models.IModel;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void PresenterCallsModelforDeal(){
        IView mockView = Mockito.mock(IView.class);
        IModel mockModel = Mockito.mock(IModel.class);
        IPresenter presenter = new MainPresenter(mockView, mockModel);
        presenter.dealCards();
        Mockito.verify(mockModel).dealGame();
    }

    @Test
    public void ModelCalledOnGetPlayerHand(){
        IView mockView = Mockito.mock(IView.class);
        IModel mockModel = Mockito.mock(IModel.class);
        IPresenter presenter = new MainPresenter(mockView, mockModel);
        presenter.getPlayerHand();
        Mockito.verify(mockModel).getPlayerHand();
    }

    @Test
    public void ModelCalledOnGetDealerHand(){
        IView mockView = Mockito.mock(IView.class);
        IModel mockModel = Mockito.mock(IModel.class);
        IPresenter presenter = new MainPresenter(mockView, mockModel);
        presenter.getDealerHand();
        Mockito.verify(mockModel).getDealerHand();
    }

    @Test
    public void ModelCalledOnHit(){
        IView mockView = Mockito.mock(IView.class);
        IModel mockModel = Mockito.mock(IModel.class);
        IPresenter presenter = new MainPresenter(mockView, mockModel);
        presenter.hit();
        Mockito.verify(mockModel).playerHit();
    }

    @Test
    public void ViewCalledOnHit() {
        IView mockView = Mockito.mock(IView.class);
        IModel mockModel = Mockito.mock(IModel.class);
        IPresenter presenter = new MainPresenter(mockView, mockModel);
        presenter.hit();
        Mockito.verify(mockView).refresh();
    }

    @Test
    public void ModelCalledOnStay(){
        IView mockView = Mockito.mock(IView.class);
        IModel mockModel = Mockito.mock(IModel.class);
        IPresenter presenter = new MainPresenter(mockView, mockModel);
        presenter.stay();
        Mockito.verify(mockModel).playerStay();
    }

    @Test
    public void ViewCalledOnShowFinalSum(){
        int sum = 18;
        boolean blackjack = false;
        IView mockView = Mockito.mock(IView.class);
        IModel mockModel = Mockito.mock(IModel.class);
        IPresenter presenter = new MainPresenter(mockView, mockModel);
        presenter.showFinalSum(sum, blackjack);
        Mockito.verify(mockView).showFinalSum(sum, blackjack);
    }

    @Test
    public void PresenterCalledOnPlayerWin(){
        boolean blackjack = true;
        int sum = 21;
        MainPresenter mockMainPresenter = Mockito.mock(MainPresenter.class);
        Game game = new Game();
        game.playerWin(blackjack);
        Mockito.verify(mockMainPresenter).showFinalSum(sum, blackjack);
    }
}
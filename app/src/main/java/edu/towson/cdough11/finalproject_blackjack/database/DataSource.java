package edu.towson.cdough11.finalproject_blackjack.database;

import java.util.List;

/**
 * Created by Sips Tea on 11/6/2017.
 */

public interface DataSource {

    int getMoney();
    void updateMoney(int money);
    void resetProfile();
}

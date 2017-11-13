package edu.towson.cdough11.finalproject_blackjack.database;

/**
 * Created by Sips Tea on 11/6/2017.
 */

public class Profile {

    public String name;
    public int money;

    public Profile(){
        name = "";
        money = 0;
    }

    public Profile(String name, int money){
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

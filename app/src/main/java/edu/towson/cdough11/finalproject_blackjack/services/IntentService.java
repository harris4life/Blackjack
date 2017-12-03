package edu.towson.cdough11.finalproject_blackjack.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.util.List;

import edu.towson.cdough11.finalproject_blackjack.Models.Card;
import edu.towson.cdough11.finalproject_blackjack.Models.Game;
import edu.towson.cdough11.finalproject_blackjack.Models.IModel;
import edu.towson.cdough11.finalproject_blackjack.SetBetActivity;

/**
 * Created by tsuba on 12/2/2017.
 */

public class IntentService extends android.app.IntentService {

    int bet = SetBetActivity.getBetAmount();
    String player_won;

    public IntentService() {
        super("Intent Service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(player_won == "win") {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(android.R.drawable.btn_star);
            builder.setContentText("You won! You earned $" + bet);
            builder.setContentTitle("Congratulations");
            Intent activityIntent = new Intent(this, SetBetActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, activityIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            Notification notification = builder.build();
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            NotificationManagerCompat.from(this).notify(1, notification);
        }
    }

    public void setResult(String result){
        player_won = result;
    }
}
//Todo - add boolean won field to Game and set to true when player wins
//public boolean won = false
//won = true; under playerWin()

//Todo- add to GameActivity under stay button click //Todo - make active after dealer details added
//if(game.won)
//startService(new Intent(this, IntentService.class));
//Game game;
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
    String result;

    public IntentService() {
        super("Intent Service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        result = intent.getStringExtra("result");
        if(result.equals("won")) {
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
        }else if(result.equals("lose")){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(android.R.drawable.btn_star);
            builder.setContentText("Sorry, you lost. You lost $" + bet);
            builder.setContentTitle("Uh Oh!");
            Intent activityIntent = new Intent(this, SetBetActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, activityIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            Notification notification = builder.build();
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            NotificationManagerCompat.from(this).notify(1, notification);
        }else{
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(android.R.drawable.btn_star);
            builder.setContentText("You pushed with the dealer. Bet amount returned");
            builder.setContentTitle("Play again?");
            Intent activityIntent = new Intent(this, SetBetActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, activityIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            Notification notification = builder.build();
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            NotificationManagerCompat.from(this).notify(1, notification);
        }
    }
}
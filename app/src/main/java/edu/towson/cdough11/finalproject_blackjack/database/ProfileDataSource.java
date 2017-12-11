package edu.towson.cdough11.finalproject_blackjack.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sips Tea on 10/30/2017.
 */

public class ProfileDataSource implements DataSource{
    private static ProfileDataSource ourInstance;
    private ProfileDBHelper dbHelper;

    public static ProfileDataSource getInstance(Context ctx) {
        ourInstance = new ProfileDataSource(ctx);
        return ourInstance;
    }

    private ProfileDataSource(Context ctx) {
        dbHelper = new ProfileDBHelper(ctx);
    }

    @Override
    public int getMoney() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String queryText = "SELECT " + DatabaseContract.MONEY_COLUMN_NAME + " FROM " + DatabaseContract.PLAYER_TABLE_NAME + ";";
        Cursor reader = db.rawQuery(queryText, null);
        if(reader.moveToNext()) {
            int money = reader.getInt(reader.getColumnIndex(DatabaseContract.MONEY_COLUMN_NAME));
            return money;
        }
        return 0;
    }

    @Override
    public void updateMoney(int money) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String queryText = "UPDATE " + DatabaseContract.PLAYER_TABLE_NAME + " SET " + DatabaseContract.MONEY_COLUMN_NAME + " = " + money + ";";
        db.execSQL(queryText);
    }

    @Override
    public void resetProfile() {
        updateMoney(500);
    }

    /*public void updateProfile(Profile originalProfile, Profile profile){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int isAwesome = profile.isAwesome() ? 1:0;
        int isAwesomeOriginal = originalProfile.isAwesome() ? 1:0;
        db.execSQL("UPDATE " + DatabaseContract.PLAYER_TABLE_NAME + " SET " +
                DatabaseContract.MONEY_COLUMN_NAME + " = '" + profile.getName() + "', " +
                DatabaseContract.ARTIST_COLUMN_NAME + " = '" + profile.getArtist() + "', " +
                DatabaseContract.PLAYER_NAME_COLUMN_NAME + " = '" + profile.getTrack() + "', " +
                DatabaseContract.IS_AWESOME_COLUMN_NAME + " = " + isAwesome +
                " WHERE " +
                DatabaseContract.MONEY_COLUMN_NAME + " = '" + originalProfile.getName() + "' AND " +
                DatabaseContract.ARTIST_COLUMN_NAME + " = '" + originalProfile.getArtist() + "' AND " +
                DatabaseContract.PLAYER_NAME_COLUMN_NAME + " = '" + originalProfile.getTrack() + "' AND " +
                DatabaseContract.IS_AWESOME_COLUMN_NAME + " = " + isAwesomeOriginal + ";");
    }*/
}

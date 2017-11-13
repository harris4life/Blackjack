package edu.towson.cdough11.finalproject_blackjack.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sips Tea on 10/30/2017.
 */

public class ProfileDataSource implements DataSource{
    private static ProfileDataSource ourInstance;
    private ProfileDBHelper dbHelper;

    public static ProfileDataSource getInstance(Context ctx) {
        if(ourInstance == null)
            ourInstance = new ProfileDataSource(ctx);
        return ourInstance;
    }

    private ProfileDataSource(Context ctx) {
        dbHelper = new ProfileDBHelper(ctx);
    }

    public List<Profile> getAllProfiles(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseContract.PLAYER_TABLE_NAME, null);
        List<Profile> list = new ArrayList<>();
        while(cursor.moveToNext()){
            Profile profile = new Profile();
            int money = cursor.getInt(cursor.getColumnIndex(DatabaseContract.MONEY_COLUMN_NAME));
            //Boolean isAwesome = cursor.getInt(cursor.getColumnIndex(DatabaseContract.IS_AWESOME_COLUMN_NAME)) == 1;
            String name = cursor.getString(cursor.getColumnIndex(DatabaseContract.PLAYER_NAME_COLUMN_NAME));
            profile.setName(name);
            profile.setMoney(money);
            list.add(profile);
        }
        return list;
    }

    public void addProfile(Profile profile){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("INSERT INTO " + DatabaseContract.PLAYER_TABLE_NAME + " " +
                        "(" + DatabaseContract.MONEY_COLUMN_NAME + ", " +
                        DatabaseContract.PLAYER_NAME_COLUMN_NAME + ", " +
                        "VALUES(" + profile.getMoney() + ", '" + profile.getName() + "');");
    }

    public void deleteProfile(Profile profile){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM " + DatabaseContract.PLAYER_TABLE_NAME + " WHERE " +
                DatabaseContract.MONEY_COLUMN_NAME + " = " + profile.getMoney() + " AND " +
                DatabaseContract.PLAYER_NAME_COLUMN_NAME + " = '" + profile.getName() + "';");
    }

    public Profile getProfile(String name){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseContract.PLAYER_TABLE_NAME + " WHERE " + DatabaseContract.PLAYER_NAME_COLUMN_NAME + " = '" + name + "';", null);
        cursor.moveToNext();
        Profile profile = new Profile();
        int money = cursor.getInt(cursor.getColumnIndex(DatabaseContract.MONEY_COLUMN_NAME));
        String pName = cursor.getString(cursor.getColumnIndex(DatabaseContract.PLAYER_NAME_COLUMN_NAME));
        profile.setMoney(money);
        profile.setName(pName);
        return profile;
    }

    public void updateProfile(Profile originalProfile, Profile profile){
        return;
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

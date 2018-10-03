package edu.towson.cdough11.finalproject_blackjack.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sips Tea on 10/30/2017.
 */

public class ProfileDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "songs.db";
    private static final int DB_VERSION = 1;

    private static final String CREATE_TABLE = "CREATE TABLE " + DatabaseContract.PLAYER_TABLE_NAME + " (" +
            DatabaseContract._ID + "INTEGER PRIMARY KEY, " +
            DatabaseContract.MONEY_COLUMN_NAME + " INTEGER);";

    public ProfileDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        addProfile(sqLiteDatabase, 500);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }

    private void addProfile(SQLiteDatabase db, int money){
        db.execSQL("INSERT INTO " + DatabaseContract.PLAYER_TABLE_NAME + " " +
                "VALUES(1, " + money + ");");
    }
}

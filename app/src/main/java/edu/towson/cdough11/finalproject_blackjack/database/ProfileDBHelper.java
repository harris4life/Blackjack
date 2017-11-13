package edu.towson.cdough11.finalproject_blackjack.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sips Tea on 10/30/2017.
 */

public class PlayerDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "songs.db";
    private static final int DB_VERSION = 1;

    private static final String CREATE_TABLE = "CREATE TABLE " + DatabaseContract.PLAYER_TABLE_NAME + " (" +
            DatabaseContract._ID + "INTEGER PRIMARY KEY, " +
            DatabaseContract.PLAYER_NAME_COLUMN_NAME + " TEXT, " +
            DatabaseContract.MONEY_COLUMN_NAME + " TEXT);";

    public PlayerDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

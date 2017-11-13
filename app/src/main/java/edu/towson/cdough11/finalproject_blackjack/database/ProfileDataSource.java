package edu.towson.cdough11.finalproject_blackjack.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Models.Player;

/**
 * Created by Sips Tea on 10/30/2017.
 */

public class PlayerDataSource implements DataSource{
    private static PlayerDataSource ourInstance;
    private PlayerDBHelper dbHelper;

    public static PlayerDataSource getInstance(Context ctx) {
        if(ourInstance == null)
            ourInstance = new PlayerDataSource(ctx);
        return ourInstance;
    }

    private PlayerDataSource(Context ctx) {
        dbHelper = new PlayerDBHelper(ctx);
    }

    public List<Player> getAllSongs(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseContract.PLAYER_TABLE_NAME, null);
        List<Player> list = new ArrayList<>();
        while(cursor.moveToNext()){
            Player song = new Player();
            String title = cursor.getString(cursor.getColumnIndex(DatabaseContract.MONEY_COLUMN_NAME));
            Boolean isAwesome = cursor.getInt(cursor.getColumnIndex(DatabaseContract.IS_AWESOME_COLUMN_NAME)) == 1;
            String track = cursor.getString(cursor.getColumnIndex(DatabaseContract.PLAYER_NAME_COLUMN_NAME));
            String artist = cursor.getString(cursor.getColumnIndex(DatabaseContract.ARTIST_COLUMN_NAME));
            song.setAwesome(isAwesome);
            song.setName(title);
            song.setTrack(Integer.parseInt(track));
            song.setArtist(artist);
            list.add(song);
        }
        return list;
    }

    public void addSong(Player song){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int isAwesome = song.isAwesome() ? 1:0;
        db.execSQL("INSERT INTO " + DatabaseContract.PLAYER_TABLE_NAME + " " +
                        "(" + DatabaseContract.MONEY_COLUMN_NAME + ", " + DatabaseContract.ARTIST_COLUMN_NAME + ", " +
                        DatabaseContract.PLAYER_NAME_COLUMN_NAME + ", " + DatabaseContract.IS_AWESOME_COLUMN_NAME + ") " +
                        "VALUES('" + song.getName() + "', '" + song.getArtist() + "', '" + song.getTrack() + "', " + isAwesome + ");");
    }

    public void deleteSong(Player song){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int isAwesome = song.isAwesome() ? 1:0;
        db.execSQL("DELETE FROM " + DatabaseContract.PLAYER_TABLE_NAME + " WHERE " +
                DatabaseContract.MONEY_COLUMN_NAME + " = '" + song.getName() + "' AND " +
                DatabaseContract.ARTIST_COLUMN_NAME + " = '" + song.getArtist() + "' AND " +
                DatabaseContract.PLAYER_NAME_COLUMN_NAME + " = '" + song.getTrack() + "' AND " +
                DatabaseContract.IS_AWESOME_COLUMN_NAME + " = " + isAwesome + ";");
    }

    public Player getSong(String name){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseContract.PLAYER_TABLE_NAME + " WHERE " + DatabaseContract.MONEY_COLUMN_NAME + " = '" + name + "';", null);
        cursor.moveToNext();
        Player song = new Player();
        String title = cursor.getString(cursor.getColumnIndex(DatabaseContract.MONEY_COLUMN_NAME));
        Boolean isAwesome = cursor.getInt(cursor.getColumnIndex(DatabaseContract.IS_AWESOME_COLUMN_NAME)) == 1;
        String track = cursor.getString(cursor.getColumnIndex(DatabaseContract.PLAYER_NAME_COLUMN_NAME));
        String artist = cursor.getString(cursor.getColumnIndex(DatabaseContract.ARTIST_COLUMN_NAME));
        song.setAwesome(isAwesome);
        song.setName(title);
        song.setTrack(Integer.parseInt(track));
        song.setArtist(artist);
        return song;
    }

    public void updateSong(Player originalSong, Player song){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int isAwesome = song.isAwesome() ? 1:0;
        int isAwesomeOriginal = originalSong.isAwesome() ? 1:0;
        db.execSQL("UPDATE " + DatabaseContract.PLAYER_TABLE_NAME + " SET " +
                DatabaseContract.MONEY_COLUMN_NAME + " = '" + song.getName() + "', " +
                DatabaseContract.ARTIST_COLUMN_NAME + " = '" + song.getArtist() + "', " +
                DatabaseContract.PLAYER_NAME_COLUMN_NAME + " = '" + song.getTrack() + "', " +
                DatabaseContract.IS_AWESOME_COLUMN_NAME + " = " + isAwesome +
                " WHERE " +
                DatabaseContract.MONEY_COLUMN_NAME + " = '" + originalSong.getName() + "' AND " +
                DatabaseContract.ARTIST_COLUMN_NAME + " = '" + originalSong.getArtist() + "' AND " +
                DatabaseContract.PLAYER_NAME_COLUMN_NAME + " = '" + originalSong.getTrack() + "' AND " +
                DatabaseContract.IS_AWESOME_COLUMN_NAME + " = " + isAwesomeOriginal + ";");
    }
}

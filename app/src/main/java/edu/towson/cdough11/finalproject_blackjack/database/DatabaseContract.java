package edu.towson.cosc431.austinfarr.lab2.database;

import android.provider.BaseColumns;

/**
 * Created by Sips Tea on 10/30/2017.
 */

public class DatabaseContract implements BaseColumns {

    public static final String TABLE_NAME = "Song";
    public static final String TITLE_COLUMN_NAME = "Title";
    public static final String IS_AWESOME_COLUMN_NAME = "IsAwesome";
    public static final String TRACK_NUMBER_COLUMN_NAME = "Track";
    public static final String ARTIST_COLUMN_NAME = "Artist";
}

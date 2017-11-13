package edu.towson.cosc431.austinfarr.lab2.database;

import java.util.List;

import models.Song;

/**
 * Created by Sips Tea on 11/6/2017.
 */

public interface DataSource {

    List<Song> getAllSongs();
    Song getSong(String name);
    void deleteSong(Song song);
    void addSong(Song song);
    void updateSong(Song originalSong, Song song);

}

package com.github.curriculeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistManager {
    // Init. a list to hold the playlist stuff
    private Playlist playlist;

    public PlaylistManager(String[] songs) {
        this.playlist = new Playlist(songs); // Sets the list that holds the playlist equal to a list version of the array input
    }

    public PlaylistManager(List<String> songs) {
        this.playlist = new Playlist(songs); // Sets them equal because they're both lists
    }

    public PlaylistManager() {
        this.playlist = new Playlist(); // Nullary constructor doing nullary shit
    }

    public Playlist getPlaylist() {
        return playlist; // returns the playlist
    }

    public void setPlaylist(Playlist playlist) {
        if ( playlist != null ) {
            this.playlist = playlist;
        } else {
            throw new IllegalArgumentException("Invalid nullary input.");
        }
    }

    private void setPlaylist(String[] toArray) {
        this.playlist = new Playlist(toArray);
    }

    public void addSong(String songToAdd) {
        if ( this.playlist != null ){
            playlist.addSong(songToAdd);
        }
    }

    public void removeSong(String songToRemove) {

    }

    public void printAll() {
        System.out.println(playlist.toString());
    }
}

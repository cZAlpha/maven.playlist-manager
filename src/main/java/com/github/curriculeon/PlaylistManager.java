package com.github.curriculeon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistManager {
    // Init. a list to hold the playlist stuff
    private List<String> playlist;

    public PlaylistManager(String[] songs) {
        this.playlist = Arrays.asList(songs); // Sets the list that holds the playlist equal to a list version of the array input
    }

    public PlaylistManager(List<String> songs) {
        this.playlist = songs; // Sets them equal because they're both lists
    }

    public PlaylistManager() {
        this.playlist = null; // Nullary constructor doing nullary shit
    }

    public Playlist getPlaylist() {
        return new Playlist(this.playlist);
    }

    public void setPlaylist(Playlist playlist) {
        if (playlist != null) {
            this.playlist = Arrays.asList(playlist.getSongNameArray());
        } else {
            System.out.println("The playlist inputted is equal to null, please try again.");
            throw new java.lang.IllegalArgumentException();
        }
    }

    private void setPlaylist(String[] toArray) {
        if (playlist != null) {
            this.playlist = Arrays.asList(toArray);
        } else {
            System.out.println("The playlist inputted is equal to null, please try again.");
            throw new java.lang.IllegalArgumentException();
        }
    }

    public void addSong(String songToAdd) {
        if ( this.playlist != null) {
            List<String> arrayList = new ArrayList<>(this.playlist);
            arrayList.add(songToAdd);
            this.playlist = arrayList;
        }
    }

    public void removeSong(String songToRemove) {
        if ( this.playlist != null) {
            playlist.remove(songToRemove);
        }
    }

    public void printAll() {
        System.out.println(playlist.toString());
    }
}

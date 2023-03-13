package com.github.curriculeon;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by leon on 1/10/2021.
 */
public class Playlist {
    // Fields
    private int currentIndex;
    private String[] songNameArray;


    public Playlist(String[] songNameArray) { // Default Constructor
        this.songNameArray = songNameArray;
        this.currentIndex = 0;
    }

    public Playlist(int currentIndex, String[] songNameArray) { // Custom Constructor
        this.songNameArray = songNameArray;
        this.currentIndex = currentIndex;
    }

    public String[] getSongNameArray() { // Returns the array full of song names
        return songNameArray;
    }

    public String getCurrentSelection() { // Returns the song that you're currently on
        return getSongNameArray()[currentIndex];
    }

    public void goToPreviousSong() {
        if ( currentIndex <= 0 ) { // If ur @ the first element of the song array
            currentIndex = getSongNameArray().length - 1;
        } else {
            currentIndex--;
        }
    }

    public void goToNextSong() {
        if ( currentIndex >= getSongNameArray().length - 1) { // If ur @ the first element of the song array
            currentIndex = 0;
        } else {
            currentIndex++;
        }
    }

    public Integer getMinimumNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        return Math.min(
                getForwardNumberOfStepsBetween(currentIndex, desiredSong),
                getBackwardNumberOfStepsBetween(currentIndex, desiredSong));
    }

    public Integer getNumberOfStepsBetween(Integer currentIndex, String desiredSong, Runnable directionMutator) {
        int numberOfSteps = 0;
        this.currentIndex = currentIndex;
        while ( !getCurrentSelection().equals(desiredSong) ) {
            directionMutator.run();
            numberOfSteps++;
        }
        return numberOfSteps;
    }

    public Integer getForwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        return getNumberOfStepsBetween(currentIndex, desiredSong, this::goToNextSong);
    }

    public Integer getBackwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        return getNumberOfStepsBetween(currentIndex, desiredSong, this::goToPreviousSong);
    }
}

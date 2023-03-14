package com.github.curriculeon.playlistmanager;

import com.github.curriculeon.Playlist;
import com.github.curriculeon.PlaylistManager;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class AddSongTest {

    @Test
    public void testAddSongOnNonEmptyPlaylist() {
        // Given
        String[] songs = {"song1", "song2", "song3"};
        PlaylistManager manager = new PlaylistManager(songs);
        String songToAdd = "song4";
        // When
        manager.addSong(songToAdd);
        // Then
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertTrue(Arrays.asList(modifiedPlaylist.getSongNameArray()).contains(songToAdd));
    }

    @Test
    public void testAddSongOnEmptyPlaylist() {
        // Given
        PlaylistManager manager = new PlaylistManager();
        String songToAdd = "song4";
        // When
        manager.addSong(songToAdd);
        // Then
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertTrue(Arrays.asList(modifiedPlaylist.getSongNameArray()).contains(songToAdd));
    }

    @Test
    public void testAddDuplicateSong() {
        // Given
        String[] songs = {"song1","song2","song3"};
        PlaylistManager manager = new PlaylistManager(songs);
        String songToAdd = "song2";
        // When
        manager.addSong(songToAdd);
        // Then
        Playlist modifiedPlaylist = manager.getPlaylist();
        int count = 0;
        for (String song : modifiedPlaylist.getSongNameArray()) {
            if (songToAdd.equals(song)) {
                count++;
            }
        }
        assertTrue(count == 2);
    }

}

package me.gabreuw.youtube_tracklist.model.cache;

import com.google.common.collect.ImmutableList;
import me.gabreuw.youtube_tracklist.model.entities.Music;

import java.util.LinkedList;
import java.util.List;

public class MusicCache {

    private final List<Music> CACHE = new LinkedList<>();

    public List<Music> getCACHE() {
        return ImmutableList.copyOf(CACHE);
    }

    public Music getByIndex(int index) {
        return CACHE.get(index);
    }

    public void add(Music music) {
        CACHE.add(music);
    }
}

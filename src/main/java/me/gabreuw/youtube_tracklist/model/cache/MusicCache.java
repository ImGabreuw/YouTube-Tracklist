package me.gabreuw.youtube_tracklist.model.cache;

import com.google.common.collect.ImmutableList;
import me.gabreuw.youtube_tracklist.model.entities.Music;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MusicCache {

    private final Queue<Music> CACHE = new LinkedList<>();

    private Music firstMusic;

    public List<Music> getCACHE() {
        return ImmutableList.copyOf(CACHE);
    }

    public void setFirstMusic() {
        this.firstMusic = this.getNext();
    }

    public Music getNext() {
        return CACHE.peek();
    }

    public Music getNextAndRemove() {
        return CACHE.poll();
    }

    public boolean hasNext() {
        return CACHE.peek() != null;
    }

    public boolean isFirst(Music music) {
        return firstMusic.equals(music);
    }

    public void add(Music music) {
        CACHE.add(music);
    }

    public void remove(Music music) {
        CACHE.remove(music);
    }
}

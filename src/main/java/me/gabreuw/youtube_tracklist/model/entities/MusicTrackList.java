package me.gabreuw.youtube_tracklist.model.entities;

import lombok.Data;

@Data
public class MusicTrackList {

    private long start;
    private long end;

    private final Music music;

    public MusicTrackList(long start, Music music) {
        this.start = start;
        this.end = start + music.getDuration();
        this.music = music;
    }
}

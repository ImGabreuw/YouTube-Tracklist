package me.gabreuw.youtube_tracklist.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MusicTrackList {

    private long start;
    private long end;

    private final Music music;

    public MusicTrackList(long start, Music music) {
        this(start, start + music.getDuration(), music);
    }
}

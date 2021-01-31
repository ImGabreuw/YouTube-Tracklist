package me.gabreuw.youtube_tracklist.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Music {

    private String name;
    private long duration;

    public Music(String name, long duration) {
        this.name = name.replace(".mp3", "");
        this.duration = duration;
    }
}


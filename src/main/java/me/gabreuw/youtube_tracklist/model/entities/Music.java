package me.gabreuw.youtube_tracklist.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Music {

    private String name;
    private long duration;

}


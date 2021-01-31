package me.gabreuw.youtube_tracklist.model.factory;

import lombok.RequiredArgsConstructor;
import me.gabreuw.youtube_tracklist.model.entities.MusicTrackList;
import me.gabreuw.youtube_tracklist.model.service.MusicService;

import java.util.List;
import java.util.Stack;

@RequiredArgsConstructor
public class TrackListFactory {

    private final MusicService SERVICE;

    public List<MusicTrackList> createTrackList() {
        Stack<MusicTrackList> trackList = new Stack<>();

        while (SERVICE.hasNext()) {
            SERVICE.getNextAndReturn(trackList);
        }

        return trackList;
    }

}

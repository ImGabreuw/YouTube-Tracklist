package me.gabreuw.youtube_tracklist.controller;

import me.gabreuw.youtube_tracklist.model.cache.MusicCache;
import me.gabreuw.youtube_tracklist.model.entities.MusicTrackList;
import me.gabreuw.youtube_tracklist.model.service.MusicService;

import java.util.ArrayList;
import java.util.List;

public class TrackListController {

    private final MusicCache CACHE;
    private final MusicService SERVICE;

    public TrackListController(MusicCache cache, MusicService service) {
        CACHE = cache;
        SERVICE = service;
    }

    public String formatMusicToTrackList(MusicTrackList music) {
        return String.format(
                "%s - %s",
                SERVICE.getFormattedAudioDuration(music.getStart()),
                music.getMusic().getName()
        );
    }

    public List<MusicTrackList> createTrackList() {
        List<MusicTrackList> trackList = new ArrayList<>();
        MusicTrackList previous = new MusicTrackList(
                0,
                CACHE.getByIndex(0)
        );

        for (int i = 1; i < CACHE.getCACHE().size(); i++) {
            trackList.add(previous);
            previous = new MusicTrackList(
                    previous.getEnd(),
                    CACHE.getByIndex(i)
            );
        }

        trackList.add(previous);

        return trackList;
    }
}

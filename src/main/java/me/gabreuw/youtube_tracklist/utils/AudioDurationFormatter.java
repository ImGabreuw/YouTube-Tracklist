package me.gabreuw.youtube_tracklist.utils;

import me.gabreuw.youtube_tracklist.model.entities.MusicTrackList;

import java.text.SimpleDateFormat;

public class AudioDurationFormatter {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("mm:ss");

    private static String formatAudioDuration(long duration) {
        return String.format(
                "%02d:%02d",
                duration / 60,
                duration % 60
        );
    }

    public static String formatMusicToTrackList(MusicTrackList music) {
        return String.format(
                "%s - %s",
                AudioDurationFormatter.formatAudioDuration(music.getStart()),
                music.getMusic().getName()
        );
    }

}

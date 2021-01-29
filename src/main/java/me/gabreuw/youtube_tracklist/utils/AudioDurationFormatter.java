package me.gabreuw.youtube_tracklist.utils;

import java.text.SimpleDateFormat;

public class AudioDurationFormatter {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("mm:ss");

    public static String formatAudioDuration(long duration) {
        return String.format(
                "%02d:%02d",
                duration / 60,
                duration % 60
        );
    }

}

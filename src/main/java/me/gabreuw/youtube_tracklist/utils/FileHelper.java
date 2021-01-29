package me.gabreuw.youtube_tracklist.utils;

import me.gabreuw.youtube_tracklist.model.entities.Music;
import me.gabreuw.youtube_tracklist.model.service.MusicService;

import java.io.File;

public class FileHelper {

    public static Music fileToMusic(MusicService service, File file) {
        return new Music(
                file.getName(),
                service.getAudioDurationFromFile(file)
        );
    }

}

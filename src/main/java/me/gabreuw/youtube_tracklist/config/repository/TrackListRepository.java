package me.gabreuw.youtube_tracklist.config.repository;

import me.gabreuw.youtube_tracklist.model.entities.MusicTrackList;
import me.gabreuw.youtube_tracklist.sercurity.error.ApplicationException;
import me.gabreuw.youtube_tracklist.utils.AudioDurationFormatter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TrackListRepository {

    public void writeTrackList(List<MusicTrackList> musics, String outputPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath, false))) {
            for (MusicTrackList music : musics) {
                writer.write(AudioDurationFormatter.formatMusicToTrackList(music));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new ApplicationException("Ocorreu um erro ao criar a tracklist.");
        }
    }
}

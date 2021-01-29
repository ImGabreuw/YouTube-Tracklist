package me.gabreuw.youtube_tracklist.config.repository;

import me.gabreuw.youtube_tracklist.controller.TrackListController;
import me.gabreuw.youtube_tracklist.model.entities.MusicTrackList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TrackListRepository {

    private final String OUTPUT = "D:\\JetBrains\\IdeaProjects\\YouTube Tracklist\\src\\main\\resources\\output.txt";

    private final TrackListController CONTROLLER;

    public TrackListRepository(TrackListController controller) {
        CONTROLLER = controller;
    }

    public void save(List<MusicTrackList> trackList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT, false))) {
            for (MusicTrackList music : trackList) {
                writer.write(CONTROLLER.formatMusicToTrackList(music));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

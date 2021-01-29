package me.gabreuw.youtube_tracklist;

import me.gabreuw.youtube_tracklist.config.repository.TrackListRepository;
import me.gabreuw.youtube_tracklist.controller.TrackListController;
import me.gabreuw.youtube_tracklist.model.cache.MusicCache;
import me.gabreuw.youtube_tracklist.model.service.MusicService;
import me.gabreuw.youtube_tracklist.utils.FileHelper;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MusicCache cache = new MusicCache();
        MusicService service = new MusicService();
        TrackListController controller = new TrackListController(cache, service);
        TrackListRepository repository = new TrackListRepository(controller);

        System.out.print("Caminho até a pasta: ");
        String folderPath = scanner.nextLine();

        File[] files = new File(folderPath).listFiles();

        if (files == null) {
            throw new RuntimeException("Não foi possível achar a pasta informada.");
        }

        Arrays.stream(files)
                .map(file -> FileHelper.fileToMusic(service, file))
                .forEach(cache::add);

        repository.save(controller.createTrackList());

        System.out.println("TrackList criada com sucesso.");

        scanner.close();
    }
}

package me.gabreuw.youtube_tracklist;

import me.gabreuw.youtube_tracklist.config.repository.TrackListRepository;
import me.gabreuw.youtube_tracklist.model.cache.MusicCache;
import me.gabreuw.youtube_tracklist.model.factory.TrackListFactory;
import me.gabreuw.youtube_tracklist.model.service.MusicService;
import me.gabreuw.youtube_tracklist.sercurity.error.ApplicationException;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            MusicCache cache = new MusicCache();
            MusicService service = new MusicService(cache);
            TrackListFactory factory = new TrackListFactory(service);
            TrackListRepository repository = new TrackListRepository();

            System.out.print("insira o caminho de entrada: ");
            String inputPath = scanner.nextLine();

            System.out.print("Insira a caminho de saída: ");
            String outputPath = scanner.nextLine();

            File[] files = new File(inputPath).listFiles();

            if (files == null) {
                throw new RuntimeException("Não foi possível achar a pasta informada.");
            }

            Arrays.stream(files)
                    .map(service::fileToMusic)
                    .forEach(service::addMusic);

            cache.setFirstMusic();

            repository.writeTrackList(
                    factory.createTrackList(),
                    outputPath
            );

            System.out.println("TrackList criada com sucesso.");
        } catch (ApplicationException e) {
            System.out.println("Não foi possível criar a TrackList. Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

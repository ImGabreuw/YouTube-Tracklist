package me.gabreuw.youtube_tracklist.model.service;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import lombok.RequiredArgsConstructor;
import me.gabreuw.youtube_tracklist.model.cache.MusicCache;
import me.gabreuw.youtube_tracklist.model.entities.Music;
import me.gabreuw.youtube_tracklist.model.entities.MusicTrackList;
import me.gabreuw.youtube_tracklist.sercurity.error.ApplicationException;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

@RequiredArgsConstructor
public class MusicService {

    private final MusicCache CACHE;

    public long getAudioDurationFromFile(File file) {
        if (file == null) {
            throw new ApplicationException("Não foi possível encontrar este arquivo.");
        }

        try {
            return new Mp3File(file).getLengthInSeconds();
        } catch (IOException | UnsupportedTagException | InvalidDataException e) {
            throw new ApplicationException("Não foi possível calcular a duração do arquivo.");
        }
    }

    public Music fileToMusic(File file) {
        return new Music(
                file.getName(),
                this.getAudioDurationFromFile(file)
        );
    }

    public void getNextAndReturn(Stack<MusicTrackList> stack) {
        Music music = CACHE.getNextAndRemove();

        stack.push(new MusicTrackList(
                CACHE.isFirst(music) ?
                        0L :
                        stack.peek().getEnd(),
                music
        ));
    }

    public boolean hasNext() {
        return CACHE.hasNext();
    }

    public void addMusic(Music music) {
        if (music == null) {
            throw new ApplicationException("Esta música não existe.");
        }

        CACHE.add(music);
    }

    public void removeMusic(Music music) {
        if (music == null) {
            throw new ApplicationException("Esta música não existe.");
        }

        if (!CACHE.getCACHE().contains(music)) {
            throw new ApplicationException("Não foi possível encontrar essa música.");
        }

        CACHE.remove(music);
    }
}

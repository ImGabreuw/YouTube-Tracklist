package me.gabreuw.youtube_tracklist.model.service;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import lombok.RequiredArgsConstructor;
import me.gabreuw.youtube_tracklist.utils.AudioDurationFormatter;

import java.io.File;
import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

@RequiredArgsConstructor
public class MusicService {

    public long getAudioDurationFromFile(File file) {
        checkNotNull(file, "Arquivo não existe.");

        try {
            return new Mp3File(file).getLengthInSeconds();
        } catch (IOException | UnsupportedTagException | InvalidDataException e) {
            throw new RuntimeException("Não foi possível calcular a duração do arquivo.");
        }
    }

    public String getFormattedAudioDuration(long duration) {
        return AudioDurationFormatter.formatAudioDuration(duration);
    }
}

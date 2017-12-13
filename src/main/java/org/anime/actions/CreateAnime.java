package org.anime.actions;

import org.anime.domain.Anime;
import org.anime.repository.AnimeRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAnime {
    private final AnimeRepository animeRepository;

    public CreateAnime(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public void execute(Anime anime) {
        animeRepository.save(anime);
    }
}

package org.anime.actions;

import org.anime.domain.Anime;
import org.anime.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAnime {
    private final AnimeRepository animeRepository;

    public GetAllAnime(AnimeRepository animeRepository) {

        this.animeRepository = animeRepository;
    }

    public List<Anime> execute() {
        return animeRepository.getAll();
    }
}

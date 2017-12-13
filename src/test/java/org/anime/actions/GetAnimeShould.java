package org.anime.actions;

import org.anime.domain.Anime;
import org.anime.repository.AnimeRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetAnimeShould {
    private AnimeRepository animeRepository;
    private GetAllAnime getAllAnime;

    @Before
    public void setUp() throws Exception {
        animeRepository = mock(AnimeRepository.class);
        getAllAnime = new GetAllAnime(animeRepository);
    }

    @Test
    public void get_all_animes() {

        getAllAnime.execute();

        verify(animeRepository).getAll();
    }
}

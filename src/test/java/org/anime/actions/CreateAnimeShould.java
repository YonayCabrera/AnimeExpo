package org.anime.actions;

import org.anime.domain.Anime;
import org.anime.repository.AnimeRepository;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateAnimeShould {

    private AnimeRepository animeRepository;
    private CreateAnime createAnime;

    @Before
    public void setUp() throws Exception {
        animeRepository = mock(AnimeRepository.class);
        createAnime = new CreateAnime(animeRepository);
    }

    @Test
    public void save_the_series() {
        Anime anime = new Anime(
                "fuu",
                "fuuka",
                "",
                "2017",
                "10",
                ""){
        };

        createAnime.execute(anime);

        verify(animeRepository).save(anime);
    }

}
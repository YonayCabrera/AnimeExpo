package org.anime.repository;

import org.anime.domain.Anime;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimeRepository {

    void save(Anime anime);

    List<Anime> getAll();
}

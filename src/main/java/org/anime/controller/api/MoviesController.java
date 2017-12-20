package org.anime.controller.api;

import org.anime.actions.GetAllAnime;
import org.anime.domain.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MoviesController {

    private final GetAllAnime getAllAnime;

    @Autowired
    public MoviesController(GetAllAnime getAllAnime){
        this.getAllAnime = getAllAnime;
    }

    @GetMapping("/api/allMovies")
    public List<Anime> getMovies(){
        return getAllAnime.execute();
    }
}

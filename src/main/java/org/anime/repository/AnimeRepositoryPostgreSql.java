package org.anime.repository;

import org.anime.domain.Anime;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class AnimeRepositoryPostgreSql implements AnimeRepository{

    private final Sql2o sql2o;
    public AnimeRepositoryPostgreSql(String connection) {
        this.sql2o = sql2o(connection);
    }


    private Sql2o sql2o(String connectionUrl) {
        return new Sql2o(connectionUrl, "root", "root");
    }

    @Override
    public void save(Anime anime) {
        final String query = "INSERT INTO anime(posterImage, title, description, year, rating, video) " +
                "VALUES (:posterImage, :title, :description, :year, :rating, :video)";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("posterImage", anime.getPosterImage())
                    .addParameter("title", anime.getTitle())
                    .addParameter("description", anime.getDescription())
                    .addParameter("year", anime.getYear())
                    .addParameter("rating", anime.getRating())
                    .addParameter("video", anime.getVideo())
                    .executeUpdate();
        }
    }

    @Override
    public List<Anime> getAll() {
        final String query = "SELECT * FROM anime";
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query).executeAndFetch(Anime.class);
        }
    }
}

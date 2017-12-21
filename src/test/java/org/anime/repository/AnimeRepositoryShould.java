package org.anime.repository;

import org.anime.domain.Anime;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.codehaus.groovy.runtime.InvokerHelper.asList;

public class AnimeRepositoryShould extends BaseRepositoryShould{

    @Override
    protected List<String> deleteFromTables() {
        return asList("anime");
    }

    private Sql2o connection;
    private AnimeRepositoryPostgreSql animeRepository;
    private Anime anime;


    @Before
    public void given_a_repository_and_a_database() {
        connection = new Sql2o(connectionTestDatabase, dbUser, dbPassword);
        animeRepository = new AnimeRepositoryPostgreSql(connectionTestDatabase);
        anime = new Anime(2, "fuu","fuuka","","2017","10","");

    }

    /*private AnimeRepositoryPostgreSql animeRepository;


    @Before
    public void setUp() {
        animeRepository = new AnimeRepositoryPostgreSql("jdbc:postgresql://localhost:5432/testdb");
    }*/

    @Test
    public void save_an_anime() {
        animeRepository.save(anime);
        Anime newAnime = getAnime();

        assertThat(newAnime.getTitle()).isEqualTo(anime.getTitle());
    }

    @Test
    public void get_all_animes(){
        insertMovie(anime);

        List<Anime>animes = animeRepository.getAll();

        assertThat(anime.getTitle()).isEqualTo(animes.get(0).getTitle());
    }

    /*private void truncateMovieTable() {
        try (Connection connection = getConnection()) {
            connection.createQuery("TRUNCATE TABLE anime").executeUpdate();
        }
    }*/

    private Anime getAnime() {
        try (Connection connection = this.connection.open()) {
            return connection.createQuery("SELECT posterImage, title, description, year, rating, video FROM anime")
                    .executeAndFetch(Anime.class).get(0);
        }
    }

    private void insertMovie(Anime anime) {
        try (Connection connection = this.connection.open()) {
            connection.createQuery("INSERT INTO anime(posterImage, title, description,year,rating,video)" +
                    " VALUES (:posterImage, :title, :description, :year, :rating, :video)")
                    .addParameter("posterImage", anime.getPosterImage())
                    .addParameter("title", anime.getTitle())
                    .addParameter("description", anime.getDescription())
                    .addParameter("year", anime.getYear())
                    .addParameter("rating", anime.getRating())
                    .addParameter("video", anime.getVideo()).executeUpdate();
        }
    }

    /*private void createMovieTable(){
        try(Connection connection = getConnection()){
            connection.createQuery("CREATE TABLE IF NOT EXISTS anime\n" +
                    "(\n" +
                    "  posterImage TEXT,\n" +
                    "  title TEXT NOT NULL,\n" +
                    "  description TEXT NOT NULL,\n" +
                    "  year TEXT NOT NULL,\n" +
                    "  rating TEXT NOT NULL,\n" +
                    "  video TEXT NOT NULL\n" +
                    ")").executeUpdate();
        }
    }*/

    /*private Connection getConnection() {
        return new Sql2o("jdbc:postgresql://localhost:5432/testdb", "root", "root").open();
    }*/
}

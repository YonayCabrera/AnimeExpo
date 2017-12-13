package org.anime.infraestructure.config;

import org.anime.repository.AnimeRepository;
import org.anime.repository.AnimeRepositoryPostgreSql;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfiguration {

    @Value("jdbc:postgresql://localhost:5432/animeycl")
    private String connection;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public AnimeRepository dataSource(){
        return new AnimeRepositoryPostgreSql(connection);
    }
}

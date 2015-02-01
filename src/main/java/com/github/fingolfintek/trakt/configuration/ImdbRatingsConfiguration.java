package com.github.fingolfintek.trakt.configuration;

import java.io.IOException;

import com.github.fingolfintek.trakt.api.SyncService;
import com.github.fingolfintek.trakt.configuration.properties.ImdbProperties;
import com.github.fingolfintek.trakt.parser.ImdbParser;
import com.github.fingolfintek.trakt.sync.ImdbRatingsImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty("imdb.ratings")
@EnableConfigurationProperties(ImdbProperties.class)
public class ImdbRatingsConfiguration {

    @Autowired
    private ImdbParser parser;

    @Autowired
    private SyncService syncService;

    @Bean
    public ImdbRatingsImporter ratingsImporter() {
        return new ImdbRatingsImporter(syncService, parser);
    }

    @Bean
    public CommandLineRunner ratingsImportRunner(ImdbProperties properties) {
        return (args) -> doImport(properties);
    }

    private void doImport(ImdbProperties properties) {
        try {
            ratingsImporter().importFrom(properties.getRatings());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

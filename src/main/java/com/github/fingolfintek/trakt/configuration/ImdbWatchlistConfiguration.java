package com.github.fingolfintek.trakt.configuration;

import java.io.IOException;

import com.github.fingolfintek.trakt.api.WatchlistSyncService;
import com.github.fingolfintek.trakt.api.model.sync.SyncResponse;
import com.github.fingolfintek.trakt.configuration.properties.ImdbProperties;
import com.github.fingolfintek.trakt.parser.ImdbParser;
import com.github.fingolfintek.trakt.sync.ImdbWatchlistImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty("imdb.watchlist")
@EnableConfigurationProperties(ImdbProperties.class)
public class ImdbWatchlistConfiguration {

    @Autowired
    private ImdbParser parser;
    
    @Autowired
    private WatchlistSyncService watchlistSyncService;

    @Bean
    public ImdbWatchlistImporter watchlistImporter() {
        return new ImdbWatchlistImporter(watchlistSyncService, parser);
    }
    
    @Bean
    public CommandLineRunner watchlistImportRunner(ImdbProperties properties) {
        return (args) -> doImport(properties);
    }

    private SyncResponse doImport(ImdbProperties properties) {
        try {
            return watchlistImporter().importFrom(properties.getWatchlist());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

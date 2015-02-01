package com.github.fingolfintek.trakt.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties("imdb")
public class ImdbProperties {

    private Resource watchlist;
    private Resource ratings;

    public Resource getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(final Resource watchlist) {
        this.watchlist = watchlist;
    }

    public Resource getRatings() {
        return ratings;
    }

    public void setRatings(final Resource ratings) {
        this.ratings = ratings;
    }
}

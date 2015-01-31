package com.github.fingolfintek.trakt.api.model.sync;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fingolfintek.trakt.api.model.TraktMovie;

public class MovieWatched extends TraktMovie {
    @JsonProperty("watched_at")
    private String watchedAt;

    public String getWatchedAt() {
        return watchedAt;
    }

    public void setWatchedAt(final String watchedAt) {
        this.watchedAt = watchedAt;
    }
}

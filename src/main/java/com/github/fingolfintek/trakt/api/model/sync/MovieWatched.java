package com.github.fingolfintek.trakt.api.model.sync;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fingolfintek.trakt.api.model.TraktExternalIds;
import com.github.fingolfintek.trakt.api.model.TraktMovie;

public class MovieWatched extends TraktMovie {
    private String watchedAt;

    public MovieWatched() {
    }

    public MovieWatched(TraktExternalIds ids) {
        super(ids);
    }

    @JsonProperty("watched_at")
    public String getWatchedAt() {
        return watchedAt;
    }

    public void setWatchedAt(final String watchedAt) {
        this.watchedAt = watchedAt;
    }
}

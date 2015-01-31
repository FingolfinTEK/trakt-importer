package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EpisodeWatched extends TraktEpisode {
    @JsonProperty("watched_at")
    private String watchedAt;

    public String getWatchedAt() {
        return watchedAt;
    }

    public void setWatchedAt(final String watchedAt) {
        this.watchedAt = watchedAt;
    }
}

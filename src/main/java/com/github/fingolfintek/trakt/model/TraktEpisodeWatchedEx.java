package com.github.fingolfintek.trakt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktEpisodeWatchedEx extends TraktEpisodeEx {
    private String watchedAt;
    private int plays ;

    @JsonProperty("watched_at")
    public String getWatchedAt() {
        return watchedAt;
    }

    public void setWatchedAt(final String watchedAt) {
        this.watchedAt = watchedAt;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(final int plays) {
        this.plays = plays;
    }
}

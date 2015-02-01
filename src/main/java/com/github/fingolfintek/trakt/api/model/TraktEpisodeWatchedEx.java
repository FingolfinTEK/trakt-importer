package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktEpisodeWatchedEx extends TraktEpisodeEx {
    private String watchedAt;
    private Integer plays;

    @JsonProperty("watched_at")
    public String getWatchedAt() {
        return watchedAt;
    }

    public void setWatchedAt(final String watchedAt) {
        this.watchedAt = watchedAt;
    }

    public Integer getPlays() {
        return plays;
    }

    public void setPlays(final Integer plays) {
        this.plays = plays;
    }
}

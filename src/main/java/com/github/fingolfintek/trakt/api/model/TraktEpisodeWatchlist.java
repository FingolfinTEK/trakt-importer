package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktEpisodeWatchlist {
    private TraktEpisode episode;
    private TraktShow show;
    @JsonProperty("inserted_at")
    private String insertedAt;

    public TraktEpisode getEpisode() {
        return episode;
    }

    public void setEpisode(final TraktEpisode episode) {
        this.episode = episode;
    }

    public TraktShow getShow() {
        return show;
    }

    public void setShow(final TraktShow show) {
        this.show = show;
    }

    public String getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(final String insertedAt) {
        this.insertedAt = insertedAt;
    }
}

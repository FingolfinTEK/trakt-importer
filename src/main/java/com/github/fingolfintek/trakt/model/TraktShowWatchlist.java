package com.github.fingolfintek.trakt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktShowWatchlist {

    private TraktShow show;
    private String insertedAt;

    public TraktShow getShow() {
        return show;
    }

    public void setShow(final TraktShow show) {
        this.show = show;
    }

    @JsonProperty("inserted_at")
    public String getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(final String insertedAt) {
        this.insertedAt = insertedAt;
    }
}

package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktMovieWatchlist {

    private TraktMovie movie;
    private String insertedAt;

    public TraktMovie getMovie() {
        return movie;
    }

    public void setMovie(final TraktMovie movie) {
        this.movie = movie;
    }

    @JsonProperty("inserted_at")
    public String getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(final String insertedAt) {
        this.insertedAt = insertedAt;
    }
}

package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktUserMovieRating {
    private String ratedAt;
    private int rating;
    private TraktMovie movie;

    @JsonProperty("rated_at")
    public String getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(final String ratedAt) {
        this.ratedAt = ratedAt;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(final int rating) {
        this.rating = rating;
    }

    public TraktMovie getMovie() {
        return movie;
    }

    public void setMovie(final TraktMovie movie) {
        this.movie = movie;
    }
}

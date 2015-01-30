package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktUserMovieRating {
    private String ratedAt;
    private Integer rating;
    private TraktMovie movie;

    @JsonProperty("rated_at")
    public String getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(final String ratedAt) {
        this.ratedAt = ratedAt;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(final Integer rating) {
        this.rating = rating;
    }

    public TraktMovie getMovie() {
        return movie;
    }

    public void setMovie(final TraktMovie movie) {
        this.movie = movie;
    }
}

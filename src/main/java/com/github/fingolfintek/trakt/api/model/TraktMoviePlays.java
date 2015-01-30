package com.github.fingolfintek.trakt.api.model;

public class TraktMoviePlays {
    private TraktMovie movie;
    private Integer plays;

    public TraktMovie getMovie() {
        return movie;
    }

    public void setMovie(final TraktMovie movie) {
        this.movie = movie;
    }

    public Integer getPlays() {
        return plays;
    }

    public void setPlays(final Integer plays) {
        this.plays = plays;
    }
}

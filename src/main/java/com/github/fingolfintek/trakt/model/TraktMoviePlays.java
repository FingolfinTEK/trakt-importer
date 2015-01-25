package com.github.fingolfintek.trakt.model;

public class TraktMoviePlays {
    private TraktMovie movie;
    private int plays;

    public TraktMovie getMovie() {
        return movie;
    }

    public void setMovie(final TraktMovie movie) {
        this.movie = movie;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(final int plays) {
        this.plays = plays;
    }
}

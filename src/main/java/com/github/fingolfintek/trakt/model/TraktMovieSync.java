package com.github.fingolfintek.trakt.model;

import java.util.List;

public class TraktMovieSync {
    private List<TraktMovie> movies;

    public List<TraktMovie> getMovies() {
        return movies;
    }

    public void setMovies(final List<TraktMovie> movies) {
        this.movies = movies;
    }
}

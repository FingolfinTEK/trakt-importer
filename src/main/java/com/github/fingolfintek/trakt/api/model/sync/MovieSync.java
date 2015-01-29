package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

import com.github.fingolfintek.trakt.api.model.TraktMovie;

public class MovieSync {
    private List<TraktMovie> movies;

    public List<TraktMovie> getMovies() {
        return movies;
    }

    public void setMovies(final List<TraktMovie> movies) {
        this.movies = movies;
    }
}

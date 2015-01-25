package com.github.fingolfintek.trakt.model;

import java.util.List;

public class TraktMovieWatchedSync {
    private List<TraktMovieWatched> movies;

    public List<TraktMovieWatched> getMovies() {
        return movies;
    }

    public void setMovies(final List<TraktMovieWatched> movies) {
        this.movies = movies;
    }
}

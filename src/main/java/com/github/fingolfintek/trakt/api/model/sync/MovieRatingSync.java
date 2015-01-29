package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

public class MovieRatingSync {
    
    private List<MovieRating> movies;

    public List<MovieRating> getMovies() {
        return movies;
    }

    public void setMovies(final List<MovieRating> movies) {
        this.movies = movies;
    }

}

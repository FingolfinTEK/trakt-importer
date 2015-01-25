package com.github.fingolfintek.trakt.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktMovieRatingSync {
    private List<TraktMovieRating> movies;

    public List<TraktMovieRating> getMovies() {
        return movies;
    }

    public void setMovies(final List<TraktMovieRating> movies) {
        this.movies = movies;
    }

    public static class TraktMovieRating extends TraktMovie {
        private String ratedAt;
        private int rating;

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
    }
}

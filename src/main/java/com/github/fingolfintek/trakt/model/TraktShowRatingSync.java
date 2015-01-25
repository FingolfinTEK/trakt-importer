package com.github.fingolfintek.trakt.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktShowRatingSync {
    private List<TraktShowRating> shows;

    public List<TraktShowRating> getShows() {
        return shows;
    }

    public void setShows(final List<TraktShowRating> shows) {
        this.shows = shows;
    }

    public static class TraktShowRating extends TraktShow {
        @JsonProperty("rated_at")
        private String ratedAt;
        private int rating;
    
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

package com.github.fingolfintek.trakt.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktEpisodeRatingSync {
    private List<TraktEpisodeRating> episodes;

    public List<TraktEpisodeRating> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(final List<TraktEpisodeRating> episodes) {
        this.episodes = episodes;
    }

    public static class TraktEpisodeRating extends TraktEpisode {
        private int rating;
        private String ratedAt;
    
        public int getRating() {
            return rating;
        }
    
        public void setRating(final int rating) {
            this.rating = rating;
        }
    
        @JsonProperty("rated_at")
        public String getRatedAt() {
            return ratedAt;
        }
    
        public void setRatedAt(final String ratedAt) {
            this.ratedAt = ratedAt;
        }
    }
}

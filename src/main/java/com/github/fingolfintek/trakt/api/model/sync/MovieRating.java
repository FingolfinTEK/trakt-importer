package com.github.fingolfintek.trakt.api.model.sync;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fingolfintek.trakt.api.model.TraktMovie;

public class MovieRating extends TraktMovie {
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

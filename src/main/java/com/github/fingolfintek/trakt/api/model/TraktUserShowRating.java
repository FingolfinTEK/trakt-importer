package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktUserShowRating {
    private String ratedAt;
    private int rating;
    private TraktShow show;

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

    public TraktShow getShow() {
        return show;
    }

    public void setShow(final TraktShow show) {
        this.show = show;
    }
}

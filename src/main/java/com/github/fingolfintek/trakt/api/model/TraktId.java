package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TraktId {
    private int trakt;
    private String slug;          

    public int getTrakt() {
        return trakt;
    }

    public void setTrakt(final int trakt) {
        this.trakt = trakt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(final String slug) {
        this.slug = slug;
    }
}

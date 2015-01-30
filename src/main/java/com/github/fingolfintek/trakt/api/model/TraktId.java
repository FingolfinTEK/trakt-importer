package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TraktId {
    private Integer trakt;
    private String slug;          

    public Integer getTrakt() {
        return trakt;
    }

    public void setTrakt(final Integer trakt) {
        this.trakt = trakt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(final String slug) {
        this.slug = slug;
    }
}

package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TraktShow {
    private String title;
    private Integer year;
    private TraktExternalIds ids;

    public TraktShow() {
    }

    public TraktShow(TraktExternalIds ids) {
        this.ids = ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(final Integer year) {
        this.year = year;
    }

    public TraktExternalIds getIds() {
        return ids;
    }

    public void setIds(final TraktExternalIds ids) {
        this.ids = ids;
    }
}

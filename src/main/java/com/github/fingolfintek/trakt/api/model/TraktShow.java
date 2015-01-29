package com.github.fingolfintek.trakt.api.model;

public class TraktShow {
    private String title;
    private int year;
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

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public TraktExternalIds getIds() {
        return ids;
    }

    public void setIds(final TraktExternalIds ids) {
        this.ids = ids;
    }
}

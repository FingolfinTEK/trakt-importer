package com.github.fingolfintek.trakt.model;

public class TraktShow {
    private String title;
    private int year;
    private TraktExternalId ids;

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

    public TraktExternalId getIds() {
        return ids;
    }

    public void setIds(final TraktExternalId ids) {
        this.ids = ids;
    }
}

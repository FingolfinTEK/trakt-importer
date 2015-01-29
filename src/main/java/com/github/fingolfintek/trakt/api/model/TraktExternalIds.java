package com.github.fingolfintek.trakt.api.model;

public class TraktExternalIds extends TraktId {
    private String imdb;
    private int tmdb;
    private int tvdb;
    private int tvrage;

    public String getImdb() {
        return imdb;
    }

    public void setImdb(final String imdb) {
        this.imdb = imdb;
    }

    public int getTmdb() {
        return tmdb;
    }

    public void setTmdb(final int tmdb) {
        this.tmdb = tmdb;
    }

    public int getTvdb() {
        return tvdb;
    }

    public void setTvdb(final int tvdb) {
        this.tvdb = tvdb;
    }

    public int getTvrage() {
        return tvrage;
    }

    public void setTvrage(final int tvrage) {
        this.tvrage = tvrage;
    }
}

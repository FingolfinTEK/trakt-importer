package com.github.fingolfintek.trakt.api.model;

public class TraktExternalIds extends TraktId {
    private String imdb;
    private Integer tmdb;
    private Integer tvdb;
    private Integer tvrage;

    public String getImdb() {
        return imdb;
    }

    public void setImdb(final String imdb) {
        this.imdb = imdb;
    }

    public Integer getTmdb() {
        return tmdb;
    }

    public void setTmdb(final Integer tmdb) {
        this.tmdb = tmdb;
    }

    public Integer getTvdb() {
        return tvdb;
    }

    public void setTvdb(final Integer tvdb) {
        this.tvdb = tvdb;
    }

    public Integer getTvrage() {
        return tvrage;
    }

    public void setTvrage(final Integer tvrage) {
        this.tvrage = tvrage;
    }
}

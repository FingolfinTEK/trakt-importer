package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

import com.github.fingolfintek.trakt.api.model.TraktShow;

public class ShowSync {
    private List<TraktShow> shows;

    public List<TraktShow> getShows() {
        return shows;
    }

    public void setShows(final List<TraktShow> shows) {
        this.shows = shows;
    }
}

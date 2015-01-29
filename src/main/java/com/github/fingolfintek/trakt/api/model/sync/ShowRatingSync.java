package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

public class ShowRatingSync {
    private List<ShowRating> shows;

    public List<ShowRating> getShows() {
        return shows;
    }

    public void setShows(final List<ShowRating> shows) {
        this.shows = shows;
    }

}

package com.github.fingolfintek.trakt.api.model;

import java.util.List;

public class TraktShowSummary extends TraktShow {
    private List<TraktSeason> seasons;

    public List<TraktSeason> getSeasons() {
        return seasons;
    }

    public void setSeasons(final List<TraktSeason> seasons) {
        this.seasons = seasons;
    }

}

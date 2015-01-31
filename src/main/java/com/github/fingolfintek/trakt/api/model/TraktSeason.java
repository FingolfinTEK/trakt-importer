package com.github.fingolfintek.trakt.api.model;

import java.util.List;

public class TraktSeason {

    private Integer number;
    private List<TraktEpisode> episodes;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(final Integer number) {
        this.number = number;
    }

    public List<TraktEpisode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(final List<TraktEpisode> episodes) {
        this.episodes = episodes;
    }
}

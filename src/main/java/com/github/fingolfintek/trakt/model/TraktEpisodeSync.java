package com.github.fingolfintek.trakt.model;

import java.util.List;

public class TraktEpisodeSync {
    private List<TraktEpisode> episodes;

    public List<TraktEpisode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(final List<TraktEpisode> episodes) {
        this.episodes = episodes;
    }
}

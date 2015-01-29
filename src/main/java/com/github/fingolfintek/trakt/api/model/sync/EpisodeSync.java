package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

import com.github.fingolfintek.trakt.api.model.TraktEpisode;

public class EpisodeSync {
    private List<TraktEpisode> episodes;

    public List<TraktEpisode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(final List<TraktEpisode> episodes) {
        this.episodes = episodes;
    }
}

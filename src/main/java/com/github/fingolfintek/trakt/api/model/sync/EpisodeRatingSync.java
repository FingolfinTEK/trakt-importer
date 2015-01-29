package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

public class EpisodeRatingSync {
    private List<EpisodeRating> episodes;

    public List<EpisodeRating> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(final List<EpisodeRating> episodes) {
        this.episodes = episodes;
    }
}

package com.github.fingolfintek.trakt.model;

import java.util.List;

public class TraktEpisodeWatchedSyncEx {
    private List<TraktShowSeasonsWatched> shows;

    public List<TraktShowSeasonsWatched> getShows() {
        return shows;
    }

    public void setShows(final List<TraktShowSeasonsWatched> shows) {
        this.shows = shows;
    }

    public static class TraktShowSeasonsWatched extends TraktShow {
        private List<TraktSeasonEpisodesWatched> seasons;
    
        public List<TraktSeasonEpisodesWatched> getSeasons() {
            return seasons;
        }
    
        public void setSeasons(final List<TraktSeasonEpisodesWatched> seasons) {
            this.seasons = seasons;
        }
    }

    public static class TraktSeasonEpisodesWatched {
        private int number;
        private List<TraktEpisodeWatchedEx> episodes;
    
        public int getNumber() {
            return number;
        }
    
        public void setNumber(final int number) {
            this.number = number;
        }
    
        public List<TraktEpisodeWatchedEx> getEpisodes() {
            return episodes;
        }
    
        public void setEpisodes(final List<TraktEpisodeWatchedEx> episodes) {
            this.episodes = episodes;
        }
    }
}

package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

import com.github.fingolfintek.trakt.api.model.TraktEpisodeEx;

public class EpisodeSyncEx {
    private List<TraktShowSeasons> shows;

    public List<TraktShowSeasons> getShows() {
        return shows;
    }

    public void setShows(final List<TraktShowSeasons> shows) {
        this.shows = shows;
    }

    public static class TraktShowSeasons {
    
        private List<TraktSeasonEpisodes> seasons;
    
        public List<TraktSeasonEpisodes> getSeasons() {
            return seasons;
        }
    
        public void setSeasons(final List<TraktSeasonEpisodes> seasons) {
            this.seasons = seasons;
        }
    }

    public static class TraktSeasonEpisodes {
        private int number;
        private List<TraktEpisodeEx> episodes;
    
        public int getNumber() {
            return number;
        }
    
        public void setNumber(final int number) {
            this.number = number;
        }
    
        public List<TraktEpisodeEx> getEpisodes() {
            return episodes;
        }
    
        public void setEpisodes(final List<TraktEpisodeEx> episodes) {
            this.episodes = episodes;
        }
    }
}

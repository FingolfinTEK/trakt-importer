package com.github.fingolfintek.trakt.model;

import java.util.List;

public class TraktShowPlays {
    private int plays;
    private TraktShowItem show;

    public int getPlays() {
        return plays;
    }

    public void setPlays(final int plays) {
        this.plays = plays;
    }

    public TraktShowItem getShow() {
        return show;
    }

    public void setShow(final TraktShowItem show) {
        this.show = show;
    }

    public static class TraktShowItem extends TraktShow {
        private List<TraktSeasonItem> seasons;
    
        public List<TraktSeasonItem> getSeasons() {
            return seasons;
        }
    
        public void setSeasons(final List<TraktSeasonItem> seasons) {
            this.seasons = seasons;
        }
    
        public static class TraktSeasonItem {
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
}

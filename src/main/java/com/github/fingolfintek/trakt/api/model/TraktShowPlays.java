package com.github.fingolfintek.trakt.api.model;

import java.util.List;

public class TraktShowPlays {
    private Integer plays;
    private TraktShowItem show;

    public Integer getPlays() {
        return plays;
    }

    public void setPlays(final Integer plays) {
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
            private Integer number;
            private List<TraktEpisodeWatchedEx> episodes;

            public Integer getNumber() {
                return number;
            }

            public void setNumber(final Integer number) {
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

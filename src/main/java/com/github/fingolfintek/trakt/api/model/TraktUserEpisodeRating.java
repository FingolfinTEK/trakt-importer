package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktUserEpisodeRating {
    private String ratedAt;
    private int rating;
    private TraktShow show;
    private TraktEpisodeSyncSummary episode;

    @JsonProperty("rated_at")
    public String getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(final String ratedAt) {
        this.ratedAt = ratedAt;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(final int rating) {
        this.rating = rating;
    }

    public TraktShow getShow() {
        return show;
    }

    public void setShow(final TraktShow show) {
        this.show = show;
    }

    public TraktEpisodeSyncSummary getEpisode() {
        return episode;
    }

    public void setEpisode(final TraktEpisodeSyncSummary episode) {
        this.episode = episode;
    }

    public static class TraktEpisodeSyncSummary {
        private TraktExternalIds ids;
        private int number;
        private int season;
        private String title;

        public TraktExternalIds getIds() {
            return ids;
        }

        public void setIds(final TraktExternalIds ids) {
            this.ids = ids;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(final int number) {
            this.number = number;
        }

        public int getSeason() {
            return season;
        }

        public void setSeason(final int season) {
            this.season = season;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(final String title) {
            this.title = title;
        }
    }
}

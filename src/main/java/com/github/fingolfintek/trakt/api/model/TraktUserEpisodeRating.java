package com.github.fingolfintek.trakt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraktUserEpisodeRating {
    private String ratedAt;
    private Integer rating;
    private TraktShow show;
    private TraktEpisodeSyncSummary episode;

    @JsonProperty("rated_at")
    public String getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(final String ratedAt) {
        this.ratedAt = ratedAt;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(final Integer rating) {
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
        private Integer number;
        private Integer season;
        private String title;

        public TraktExternalIds getIds() {
            return ids;
        }

        public void setIds(final TraktExternalIds ids) {
            this.ids = ids;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(final Integer number) {
            this.number = number;
        }

        public Integer getSeason() {
            return season;
        }

        public void setSeason(final Integer season) {
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

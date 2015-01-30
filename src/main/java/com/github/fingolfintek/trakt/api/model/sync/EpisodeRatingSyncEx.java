package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fingolfintek.trakt.api.model.TraktEpisodeEx;
import com.github.fingolfintek.trakt.api.model.TraktShow;

public class EpisodeRatingSyncEx {
    private List<TraktShowSeasonsRating> shows;

    public List<TraktShowSeasonsRating> getShows() {
        return shows;
    }

    public void setShows(final List<TraktShowSeasonsRating> shows) {
        this.shows = shows;
    }

    public static class TraktShowSeasonsRating extends TraktShow {
        private List<TraktSeasonEpisodesRating> seasons;
    
        public List<TraktSeasonEpisodesRating> getSeasons() {
            return seasons;
        }
    
        public void setSeasons(final List<TraktSeasonEpisodesRating> seasons) {
            this.seasons = seasons;
        }
    }

    public static class TraktSeasonEpisodesRating {
        private Integer number;
        private List<TraktEpisodeRatingEx> episodes;
    
        public Integer getNumber() {
            return number;
        }
    
        public void setNumber(final Integer number) {
            this.number = number;
        }
    
        public List<TraktEpisodeRatingEx> getEpisodes() {
            return episodes;
        }
    
        public void setEpisodes(final List<TraktEpisodeRatingEx> episodes) {
            this.episodes = episodes;
        }
    }

    public static class TraktEpisodeRatingEx extends TraktEpisodeEx {
        private String ratedAt;
        private Integer rating;

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
    }
}

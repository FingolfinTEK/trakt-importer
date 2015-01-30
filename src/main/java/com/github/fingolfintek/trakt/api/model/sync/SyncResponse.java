package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fingolfintek.trakt.api.model.TraktEpisode;
import com.github.fingolfintek.trakt.api.model.TraktMovie;
import com.github.fingolfintek.trakt.api.model.TraktShow;

public class SyncResponse {
    private AddedItems added;
    private NotFoundItems notFound;

    public AddedItems getAdded() {
        return added;
    }

    public void setAdded(final AddedItems added) {
        this.added = added;
    }

    @JsonProperty("not_found")
    public NotFoundItems getNotFound() {
        return notFound;
    }

    public void setNotFound(final NotFoundItems notFound) {
        this.notFound = notFound;
    }

    public static class AddedItems {
        private Integer movies;
        private Integer shows;
        private Integer seasons;
        private Integer episodes;

        public Integer getMovies() {
            return movies;
        }

        public void setMovies(final Integer movies) {
            this.movies = movies;
        }

        public Integer getShows() {
            return shows;
        }

        public void setShows(final Integer shows) {
            this.shows = shows;
        }

        public Integer getSeasons() {
            return seasons;
        }

        public void setSeasons(final Integer seasons) {
            this.seasons = seasons;
        }

        public Integer getEpisodes() {
            return episodes;
        }

        public void setEpisodes(final Integer episodes) {
            this.episodes = episodes;
        }
    }

    public static class NotFoundItems {
        private List<TraktMovie> movies;
        private List<TraktShow> shows;
        private List<TraktEpisode> episodes;

        public List<TraktMovie> getMovies() {
            return movies;
        }

        public void setMovies(final List<TraktMovie> movies) {
            this.movies = movies;
        }

        public List<TraktShow> getShows() {
            return shows;
        }

        public void setShows(final List<TraktShow> shows) {
            this.shows = shows;
        }

        public List<TraktEpisode> getEpisodes() {
            return episodes;
        }

        public void setEpisodes(final List<TraktEpisode> episodes) {
            this.episodes = episodes;
        }
    }
}

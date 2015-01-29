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
        private int movies;
        private int shows;
        private int seasons;
        private int episodes;

        public int getMovies() {
            return movies;
        }

        public void setMovies(final int movies) {
            this.movies = movies;
        }

        public int getShows() {
            return shows;
        }

        public void setShows(final int shows) {
            this.shows = shows;
        }

        public int getSeasons() {
            return seasons;
        }

        public void setSeasons(final int seasons) {
            this.seasons = seasons;
        }

        public int getEpisodes() {
            return episodes;
        }

        public void setEpisodes(final int episodes) {
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

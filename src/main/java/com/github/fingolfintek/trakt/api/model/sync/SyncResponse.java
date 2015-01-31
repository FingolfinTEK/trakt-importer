package com.github.fingolfintek.trakt.api.model.sync;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fingolfintek.trakt.api.model.TraktEpisode;
import com.github.fingolfintek.trakt.api.model.TraktMovie;
import com.github.fingolfintek.trakt.api.model.TraktShow;

public class SyncResponse {
    private NumberedItems added = new NumberedItems();
    private NumberedItems existing = new NumberedItems();
    private NotFoundItems notFound = new NotFoundItems();

    public NumberedItems getAdded() {
        return added;
    }

    public void setAdded(final NumberedItems added) {
        this.added = added;
    }

    public NumberedItems getExisting() {
        return existing;
    }

    public void setExisting(final NumberedItems existing) {
        this.existing = existing;
    }

    @JsonProperty("not_found")
    public NotFoundItems getNotFound() {
        return notFound;
    }

    public void setNotFound(final NotFoundItems notFound) {
        this.notFound = notFound;
    }

    public SyncResponse combinedWith(SyncResponse other) {
        SyncResponse combined = new SyncResponse();
        combined.combineWith(this);
        combined.combineWith(other);
        return combined;
    }
    
    private void combineWith(SyncResponse other) {
        added.combineWith(other.added);
        notFound.combineWith(other.notFound);
    }

    public static class NumberedItems {
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
        
        public void combineWith(NumberedItems other) {
            movies += other.movies;
            shows += other.shows;
            seasons += other.seasons;
            episodes += other.episodes;
        }
    }

    public static class NotFoundItems {
        private List<TraktMovie> movies = new ArrayList<>();
        private List<TraktShow> shows = new ArrayList<>();
        private List<TraktEpisode> episodes = new ArrayList<>();

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

        public void combineWith(NotFoundItems other) {
            movies.addAll(other.movies);
            shows.addAll(other.shows);
            episodes.addAll(other.episodes);
        }
    }
}

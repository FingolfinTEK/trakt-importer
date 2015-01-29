package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

import com.github.fingolfintek.trakt.api.model.TraktEpisode;
import com.github.fingolfintek.trakt.api.model.TraktMovie;
import com.github.fingolfintek.trakt.api.model.TraktShow;

public class CollectionSync {
    private List<TraktMovie> movies;
    private List<TraktShow> shows;
    private List<TraktEpisode> episodes;
    
    public CollectionSync() {
    }

    public CollectionSync(List<TraktMovie> movies, List<TraktShow> shows) {
        this.movies = movies;
        this.shows = shows;
    }
    
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

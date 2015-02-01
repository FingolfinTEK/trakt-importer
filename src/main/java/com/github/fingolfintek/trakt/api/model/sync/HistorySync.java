package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistorySync {
    private List<MovieWatched> movies;
    private List<ShowWatched> shows;
    private List<EpisodeWatched> episodes;
    
    public HistorySync() {
    }

    public HistorySync(List<MovieWatched> movies, List<ShowWatched> shows) {
        this.movies = movies;
        this.shows = shows;
    }
    
    public List<MovieWatched> getMovies() {
        return movies;
    }

    public void setMovies(final List<MovieWatched> movies) {
        this.movies = movies;
    }

    public List<ShowWatched> getShows() {
        return shows;
    }

    public void setShows(final List<ShowWatched> shows) {
        this.shows = shows;
    }

    public List<EpisodeWatched> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(final List<EpisodeWatched> episodes) {
        this.episodes = episodes;
    }
}

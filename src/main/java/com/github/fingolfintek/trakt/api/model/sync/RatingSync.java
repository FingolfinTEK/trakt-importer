package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

public class RatingSync {
    
    private List<MovieRating> movies;
    private List<EpisodeRating> episodes;
    private List<ShowRating> shows;

    public List<MovieRating> getMovies() {
        return movies;
    }

    public void setMovies(final List<MovieRating> movies) {
        this.movies = movies;
    }

    public List<EpisodeRating> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(final List<EpisodeRating> episodes) {
        this.episodes = episodes;
    }

    public List<ShowRating> getShows() {
        return shows;
    }

    public void setShows(final List<ShowRating> shows) {
        this.shows = shows;
    }

}

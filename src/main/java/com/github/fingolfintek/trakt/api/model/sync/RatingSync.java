package com.github.fingolfintek.trakt.api.model.sync;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatingSync {
    
    private List<MovieRating> movies;
    private List<EpisodeRating> episodes;
    private List<ShowRating> shows;

    public RatingSync() {
    }

    public RatingSync(List<MovieRating> movies, List<ShowRating> shows) {
        this.movies = movies;
        this.shows = shows;
    }

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

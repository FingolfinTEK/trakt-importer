package com.github.fingolfintek.trakt.api;

import com.github.fingolfintek.trakt.model.*;
import retrofit.http.POST;

public interface TraktService {

    @POST("/sync/collection")
    TraktSyncResponse addMovies(TraktMovieSync sync);

    @POST("/sync/collection")
    TraktSyncResponse addShows(TraktShowSync sync);

    @POST("/sync/collection")
    TraktSyncResponse addEpisodes(TraktEpisodeSync sync);

    @POST("/sync/ratings") 
    TraktSyncResponse addMovieRatings(TraktMovieRatingSync sync);

    @POST("/sync/ratings")
    TraktSyncResponse addShowRatings(TraktShowRatingSync sync);

    @POST("/sync/ratings")
    TraktSyncResponse addEpisodeRatings(TraktEpisodeRatingSync sync);
}

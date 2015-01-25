package com.github.fingolfintek.trakt.api;

import com.github.fingolfintek.trakt.model.*;
import retrofit.http.Body;
import retrofit.http.POST;

public interface TraktService {

    @POST("/sync/collection")
    TraktSyncResponse addMovies(@Body TraktMovieSync sync);

    @POST("/sync/collection")
    TraktSyncResponse addShows(@Body TraktShowSync sync);

    @POST("/sync/collection")
    TraktSyncResponse addEpisodes(@Body TraktEpisodeSync sync);

    @POST("/sync/ratings") 
    TraktSyncResponse addMovieRatings(@Body TraktMovieRatingSync sync);

    @POST("/sync/ratings")
    TraktSyncResponse addShowRatings(@Body TraktShowRatingSync sync);

    @POST("/sync/ratings")
    TraktSyncResponse addEpisodeRatings(@Body TraktEpisodeRatingSync sync);
}

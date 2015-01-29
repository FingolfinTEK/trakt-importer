package com.github.fingolfintek.trakt.api;

import com.github.fingolfintek.trakt.api.model.sync.*;
import retrofit.http.Body;
import retrofit.http.POST;

public interface SyncService extends WatchlistSyncService {

    @POST("/sync/collection") SyncResponse syncMovies(@Body MovieSync sync);

    @POST("/sync/collection") SyncResponse syncShows(@Body ShowSync sync);

    @POST("/sync/collection") SyncResponse syncEpisodes(@Body EpisodeSync sync);

    @POST("/sync/ratings") SyncResponse syncMovieRatings(@Body RatingSync sync);

    @POST("/sync/ratings") SyncResponse syncShowRatings(@Body ShowRatingSync sync);

    @POST("/sync/ratings") SyncResponse syncEpisodeRatings(@Body EpisodeRatingSync sync);

}

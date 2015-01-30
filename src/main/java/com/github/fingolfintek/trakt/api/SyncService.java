package com.github.fingolfintek.trakt.api;

import com.github.fingolfintek.trakt.api.model.sync.*;
import retrofit.http.Body;
import retrofit.http.POST;

public interface SyncService {

    @POST("/sync/collection") SyncResponse syncMovies(@Body MovieSync sync);

    @POST("/sync/collection") SyncResponse syncShows(@Body ShowSync sync);

    @POST("/sync/collection") SyncResponse syncEpisodes(@Body EpisodeSync sync);

    @POST("/sync/ratings") SyncResponse syncMovieRatings(@Body MovieRatingSync sync);

    @POST("/sync/ratings") SyncResponse syncShowRatings(@Body ShowRatingSync sync);

    @POST("/sync/ratings") SyncResponse syncEpisodeRatings(@Body EpisodeRatingSync sync);

    @POST("/sync/ratings") SyncResponse syncRatings(@Body RatingSync sync);
    
    @POST("/sync/watchlist") SyncResponse syncMovieWatchlist(@Body MovieSync sync);

    @POST("/sync/watchlist") SyncResponse syncShowWatchlist(@Body ShowSync sync);

    @POST("/sync/watchlist") SyncResponse syncEpisodeWatchlist(@Body EpisodeSync sync);

    @POST("/sync/watchlist") SyncResponse syncWatchlist(@Body CollectionSync sync);

}

package com.github.fingolfintek.trakt.api;

import com.github.fingolfintek.trakt.api.model.sync.*;
import retrofit.http.Body;
import retrofit.http.POST;

public interface WatchlistSyncService {
    @POST("/sync/watchlist") SyncResponse syncMovieWatchlist(@Body MovieSync sync);

    @POST("/sync/watchlist") SyncResponse syncShowWatchlist(@Body ShowSync sync);

    @POST("/sync/watchlist") SyncResponse syncEpisodeWatchlist(@Body EpisodeSync sync);
    
    @POST("/sync/watchlist") SyncResponse syncMovieWatchlist(@Body CollectionSync sync);
}

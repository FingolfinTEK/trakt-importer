package com.github.fingolfintek.trakt.api;

import com.github.fingolfintek.trakt.api.model.sync.*;
import retrofit.http.Body;
import retrofit.http.POST;

public interface SyncService {

    @POST("/sync/collection") SyncResponse syncCollection(@Body CollectionSync sync);

    @POST("/sync/history") SyncResponse syncHistory(@Body CollectionSync sync);

    @POST("/sync/ratings") SyncResponse syncRatings(@Body RatingSync sync);
    
    @POST("/sync/watchlist") SyncResponse syncWatchlist(@Body CollectionSync sync);

}

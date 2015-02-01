package com.github.fingolfintek.trakt.api;

import com.github.fingolfintek.trakt.api.model.sync.CollectionSync;
import com.github.fingolfintek.trakt.api.model.sync.HistorySync;
import com.github.fingolfintek.trakt.api.model.sync.RatingSync;
import com.github.fingolfintek.trakt.api.model.sync.SyncResult;
import retrofit.http.Body;
import retrofit.http.POST;

public interface SyncService {

    @POST("/sync/collection") SyncResult syncCollection(@Body CollectionSync sync);

    @POST("/sync/history") SyncResult syncHistory(@Body HistorySync sync);

    @POST("/sync/ratings") SyncResult syncRatings(@Body RatingSync sync);

    @POST("/sync/watchlist") SyncResult syncWatchlist(@Body CollectionSync sync);

}

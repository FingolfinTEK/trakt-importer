package com.github.fingolfintek.trakt.sync;

import java.util.List;
import java.util.function.BiFunction;

import com.github.fingolfintek.trakt.api.SyncService;
import com.github.fingolfintek.trakt.api.model.TraktExternalIds;
import com.github.fingolfintek.trakt.api.model.TraktMovie;
import com.github.fingolfintek.trakt.api.model.TraktShow;
import com.github.fingolfintek.trakt.api.model.sync.CollectionSync;
import com.github.fingolfintek.trakt.api.model.sync.SyncResult;
import com.github.fingolfintek.trakt.model.ImdbEntry;
import com.github.fingolfintek.trakt.parser.ImdbParser;

public class ImdbWatchlistImporter extends BaseImdbRatingsImporter<TraktExternalIds> {

    public ImdbWatchlistImporter(final SyncService syncService, final ImdbParser parser) {
        super(syncService, parser);
    }

    @Override
    protected SyncResult importFrom(final List<ImdbEntry> entries) {
        return new WatchlistImportOperation().importFrom(entries);
    }

    private BiFunction<List<TraktMovie>, List<TraktShow>, SyncResult> watchlistSyncer() {
        return (m, s) -> syncService.syncWatchlist(new CollectionSync(m, s));
    }

    private class WatchlistImportOperation extends ImportOperation<TraktExternalIds, TraktMovie, TraktShow> {

        public WatchlistImportOperation() {
            super(TraktMovie::new, TraktShow::new, ImdbWatchlistImporter.this::toIds, watchlistSyncer());
        }

        @Override
        protected String getDescription() {
            return "watchlist";
        }

    }

}

package com.github.fingolfintek.trakt.sync;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.github.fingolfintek.trakt.api.SyncService;
import com.github.fingolfintek.trakt.api.model.TraktExternalIds;
import com.github.fingolfintek.trakt.api.model.TraktMovie;
import com.github.fingolfintek.trakt.api.model.TraktShow;
import com.github.fingolfintek.trakt.api.model.sync.CollectionSync;
import com.github.fingolfintek.trakt.api.model.sync.SyncResponse;
import com.github.fingolfintek.trakt.model.ImdbEntry;
import com.github.fingolfintek.trakt.parser.ImdbParser;

import static java.util.stream.Collectors.toList;

public class ImdbWatchlistImporter extends BaseImdbRatingsImporter {

    public ImdbWatchlistImporter(final SyncService syncService, final ImdbParser parser) {
        super(syncService, parser);
    }

    @Override
    protected SyncResponse importFrom(final List<ImdbEntry> entries) {
        List<TraktMovie> movies = filterAndMap(entries, IS_SHOW.negate(), TraktMovie::new);
        List<TraktShow> shows = filterAndMap(entries, IS_SHOW, TraktShow::new);
        logger.info("Importing {} movies and {} series into watchlist", movies.size(), shows.size());
        return syncService.syncWatchlist(new CollectionSync(movies, shows));
    }

    private <R> List<R> filterAndMap(List<ImdbEntry> watchlist, Predicate<ImdbEntry> predicate, Function<TraktExternalIds, R> mapper) {
        return watchlist.stream().filter(predicate).map(ImdbEntry::toIds).map(mapper).collect(toList());
    }
}

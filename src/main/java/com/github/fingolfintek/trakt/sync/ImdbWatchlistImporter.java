package com.github.fingolfintek.trakt.sync;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.github.fingolfintek.trakt.api.WatchlistSyncService;
import com.github.fingolfintek.trakt.api.model.TraktExternalIds;
import com.github.fingolfintek.trakt.api.model.TraktMovie;
import com.github.fingolfintek.trakt.api.model.TraktShow;
import com.github.fingolfintek.trakt.api.model.sync.CollectionSync;
import com.github.fingolfintek.trakt.api.model.sync.SyncResponse;
import com.github.fingolfintek.trakt.model.ImdbEntry;
import com.github.fingolfintek.trakt.parser.ImdbParser;
import org.springframework.core.io.Resource;

import static java.util.stream.Collectors.toList;

public class ImdbWatchlistImporter implements ResourceImporter {

    public static final Predicate<ImdbEntry> IS_SHOW = ImdbEntry::isShow;
    private final WatchlistSyncService watchlistSyncService;
    private final ImdbParser parser;

    public ImdbWatchlistImporter(final WatchlistSyncService watchlistSyncService, final ImdbParser parser) {
        this.watchlistSyncService = watchlistSyncService;
        this.parser = parser;
    }

    @Override
    public SyncResponse importFrom(final Resource resource) throws IOException {
        List<ImdbEntry> entries = parser.parse(resource);
        List<TraktMovie> movies = filterAndMap(entries, IS_SHOW.negate(), TraktMovie::new);
        List<TraktShow> shows = filterAndMap(entries, IS_SHOW, TraktShow::new);
        return watchlistSyncService.syncMovieWatchlist(new CollectionSync(movies, shows));
    }

    private <R> List<R> filterAndMap(List<ImdbEntry> watchlist, Predicate<ImdbEntry> predicate, Function<TraktExternalIds, R> mapper) {
        return watchlist.stream().filter(predicate).map(ImdbEntry::toIds).map(mapper).collect(toList());
    }
}

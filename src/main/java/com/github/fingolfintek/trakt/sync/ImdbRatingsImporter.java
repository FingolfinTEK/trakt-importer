package com.github.fingolfintek.trakt.sync;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.github.fingolfintek.trakt.api.SyncService;
import com.github.fingolfintek.trakt.api.model.sync.MovieRating;
import com.github.fingolfintek.trakt.api.model.sync.RatingSync;
import com.github.fingolfintek.trakt.api.model.sync.ShowRating;
import com.github.fingolfintek.trakt.api.model.sync.SyncResponse;
import com.github.fingolfintek.trakt.model.ImdbEntry;
import com.github.fingolfintek.trakt.parser.ImdbParser;
import com.github.fingolfintek.trakt.util.Pair;
import org.springframework.core.io.Resource;

import static java.util.stream.Collectors.toList;

public class ImdbRatingsImporter implements ResourceImporter {

    public static final Predicate<ImdbEntry> IS_SHOW = ImdbEntry::isShow;
    private final SyncService syncService;
    private final ImdbParser parser;

    public ImdbRatingsImporter(final SyncService syncService, final ImdbParser parser) {
        this.syncService = syncService;
        this.parser = parser;
    }

    @Override
    public SyncResponse importFrom(final Resource resource) throws IOException {
        List<ImdbEntry> entries = parser.parse(resource);
        List<MovieRating> movies = filterAndMap(entries, IS_SHOW.negate(), MovieRating::new);
        List<ShowRating> shows = filterAndMap(entries, IS_SHOW, ShowRating::new);
        return syncService.syncRatings(new RatingSync(movies, shows));
    }

    private <R> List<R> filterAndMap(List<ImdbEntry> watchlist, Predicate<ImdbEntry> predicate, Function<Pair, R> mapper) {
        return watchlist.stream().filter(predicate).map(ImdbEntry::toIdsWithRating).map(mapper).collect(toList());
    }
}

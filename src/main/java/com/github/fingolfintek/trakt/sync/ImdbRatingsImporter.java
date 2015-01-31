package com.github.fingolfintek.trakt.sync;

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

import static java.util.stream.Collectors.toList;

public class ImdbRatingsImporter extends BaseImdbRatingsImporter {

    public ImdbRatingsImporter(final SyncService syncService, final ImdbParser parser) {
        super(syncService, parser);
    }

    @Override 
    protected SyncResponse importFrom(final List<ImdbEntry> entries) {
        List<MovieRating> movies = filterAndMap(entries, IS_SHOW.negate(), MovieRating::new);
        List<ShowRating> shows = filterAndMap(entries, IS_SHOW, ShowRating::new);
        logger.info("Importing {} movie and {} series ratings", movies.size(), shows.size());
        return syncService.syncRatings(new RatingSync(movies, shows));
    }

    private <R> List<R> filterAndMap(List<ImdbEntry> ratings, Predicate<ImdbEntry> predicate, Function<Pair, R> mapper) {
        return ratings.stream().filter(predicate).map(ImdbEntry::toIdsWithRating).map(mapper).collect(toList());
    }
}

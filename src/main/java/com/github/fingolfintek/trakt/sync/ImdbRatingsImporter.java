package com.github.fingolfintek.trakt.sync;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.github.fingolfintek.trakt.api.SyncService;
import com.github.fingolfintek.trakt.api.model.TraktExternalIds;
import com.github.fingolfintek.trakt.api.model.sync.*;
import com.github.fingolfintek.trakt.model.ImdbEntry;
import com.github.fingolfintek.trakt.parser.ImdbParser;
import com.github.fingolfintek.trakt.util.Pair;

import static java.lang.Integer.parseInt;

public class ImdbRatingsImporter extends BaseImdbRatingsImporter<Pair> {
    
    private final Function<ImdbEntry, Pair> toIdsWithRatings = (e) -> new Pair<>(toIds(e), parseInt(e.getRating()));

    public ImdbRatingsImporter(final SyncService syncService, final ImdbParser parser) {
        super(syncService, parser);
    }

    @Override
    protected SyncResult importFrom(final List<ImdbEntry> entries) {
        final SyncResult ratingsImportResult = new RatingsImportOperation().importFrom(entries);
        final SyncResult historyImportResult = new HistoryImportOperation().importFrom(entries);
        return ratingsImportResult.combinedWith(historyImportResult);
    }

    private class RatingsImportOperation extends ImportOperation<Pair, MovieRating, ShowRating> {
        public RatingsImportOperation() {
            super(MovieRating::new, ShowRating::new, toIdsWithRatings, ratingsSyncer());
        }
    }

    private BiFunction<List<MovieRating>, List<ShowRating>, SyncResult> ratingsSyncer() {
        return (m, s) -> {
            logger.info("Importing ratings for {} movies and {} series", m.size(), s.size());
            return syncService.syncRatings(new RatingSync(m, s));
        };
    }

    private class HistoryImportOperation extends ImportOperation<TraktExternalIds, MovieWatched, ShowWatched> {
        public HistoryImportOperation() {
            super(MovieWatched::new, ShowWatched::new, ImdbRatingsImporter.this::toIds, historySyncer());
        }
    }

    private BiFunction<List<MovieWatched>, List<ShowWatched>, SyncResult> historySyncer() {
        return (m, s) -> {
            logger.info("Importing history for {} movies and {} series", m.size(), s.size());
            return syncService.syncHistory(new HistorySync(m, s));
        };
    }

}

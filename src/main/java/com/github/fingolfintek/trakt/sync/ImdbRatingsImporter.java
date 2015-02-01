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

public class ImdbRatingsImporter extends BaseImdbRatingsImporter {

    private final Function<ImdbEntry, Pair> toIdsWithRatings = (e) -> new Pair<>(toIds(e), parseInt(e.getRating()));
    private final RatingsImportOperation ratingsImportOperation = new RatingsImportOperation();
    private final HistoryImportOperation historyImportOperation = new HistoryImportOperation();

    public ImdbRatingsImporter(final SyncService syncService, final ImdbParser parser) {
        super(syncService, parser);
    }

    @Override
    protected SyncResult importFrom(final List<ImdbEntry> entries) {
        return ratingsImport(entries).combinedWith(historyImport(entries));
    }

    private SyncResult ratingsImport(final List<ImdbEntry> entries) {
        return ratingsImportOperation.importFrom(entries);
    }

    private SyncResult historyImport(final List<ImdbEntry> entries) {
        return historyImportOperation.importFrom(entries);
    }

    private BiFunction<List<MovieWatched>, List<ShowWatched>, SyncResult> historySyncer() {
        return (m, s) -> syncService.syncHistory(new HistorySync(m, s));
    }

    private BiFunction<List<MovieRating>, List<ShowRating>, SyncResult> ratingsSyncer() {
        return (m, s) -> syncService.syncRatings(new RatingSync(m, s));
    }

    private class RatingsImportOperation extends ImportOperation<Pair, MovieRating, ShowRating> {

        public RatingsImportOperation() {
            super(MovieRating::new, ShowRating::new, toIdsWithRatings, ratingsSyncer());
        }

        @Override
        protected String getDescription() {
            return "ratings";
        }
    }

    private class HistoryImportOperation extends ImportOperation<TraktExternalIds, MovieWatched, ShowWatched> {

        public HistoryImportOperation() {
            super(MovieWatched::new, ShowWatched::new, ImdbRatingsImporter.this::toIds, historySyncer());
        }

        @Override
        protected String getDescription() {
            return "history";
        }
    }

}

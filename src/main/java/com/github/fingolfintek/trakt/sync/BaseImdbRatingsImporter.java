package com.github.fingolfintek.trakt.sync;

import java.io.IOException;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.github.fingolfintek.trakt.api.SyncService;
import com.github.fingolfintek.trakt.api.model.TraktExternalIds;
import com.github.fingolfintek.trakt.api.model.sync.SyncResult;
import com.github.fingolfintek.trakt.model.ImdbEntry;
import com.github.fingolfintek.trakt.parser.ImdbParser;
import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import static java.util.stream.Collectors.toList;

public abstract class BaseImdbRatingsImporter<I> implements ResourceImporter {
    protected static final Predicate<ImdbEntry> IS_SHOW = ImdbEntry::isShow;
    private static final int PARTITION_SIZE = 100;

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected final SyncService syncService;
    private final ImdbParser parser;

    public BaseImdbRatingsImporter(final SyncService syncService, final ImdbParser parser) {
        this.syncService = syncService;
        this.parser = parser;
    }

    @Override
    public SyncResult importFrom(final Resource resource) throws IOException {
        final Stream<List<ImdbEntry>> partition = parseAndPartition(resource);
        return partition.map(this::importFrom).reduce(SyncResult::combinedWith).get();
    }

    private Stream<List<ImdbEntry>> parseAndPartition(final Resource resource) throws IOException {
        final List<ImdbEntry> entries = parser.parse(resource);
        logger.info("Loaded {} entries and partitioned them into batches of {} entries", entries.size(), PARTITION_SIZE);
        return ListUtils.partition(entries, PARTITION_SIZE).stream();
    }

    protected abstract SyncResult importFrom(List<ImdbEntry> entries);

    protected TraktExternalIds toIds(ImdbEntry entry) {
        final TraktExternalIds ids = new TraktExternalIds();
        ids.setImdb(entry.getId());
        return ids;
    }

    public class ImportOperation<E, M, S> {
        private final Function<E, M> movieMapper;
        private final Function<E, S> showMapper;
        private final Function<ImdbEntry, E> intermediateMapper;
        private final BiFunction<List<M>, List<S>, SyncResult> importFunction;

        public ImportOperation(final Function<E, M> movieMapper, final Function<E, S> showMapper,
                final Function<ImdbEntry, E> intermediateMapper, final BiFunction<List<M>, List<S>, SyncResult> importFunction) {
            this.movieMapper = movieMapper;
            this.showMapper = showMapper;
            this.intermediateMapper = intermediateMapper;
            this.importFunction = importFunction;
        }

        protected SyncResult importFrom(final List<ImdbEntry> entries) {
            List<M> movies = filterAndMap(entries, IS_SHOW.negate(), movieMapper);
            List<S> shows = filterAndMap(entries, IS_SHOW, showMapper);
            logger.info("Importing {} movie and {} series ratings", movies.size(), shows.size());
            return importFunction.apply(movies, shows);
        }

        protected <R> List<R> filterAndMap(List<ImdbEntry> watchlist, Predicate<ImdbEntry> predicate, Function<E, R> mapper) {
            return watchlist.stream().filter(predicate).map(entryMapper(mapper)).collect(toList());
        }

        protected <R> Function<ImdbEntry, R> entryMapper(final Function<E, R> mapper) {
            return new FunctionBasedEntryMapper<>(intermediateMapper, mapper)::map;
        }

    }
}

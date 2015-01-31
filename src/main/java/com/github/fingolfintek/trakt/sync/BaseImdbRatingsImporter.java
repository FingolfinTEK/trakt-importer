package com.github.fingolfintek.trakt.sync;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.github.fingolfintek.trakt.api.SyncService;
import com.github.fingolfintek.trakt.api.model.sync.SyncResponse;
import com.github.fingolfintek.trakt.model.ImdbEntry;
import com.github.fingolfintek.trakt.parser.ImdbParser;
import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

public abstract class BaseImdbRatingsImporter implements ResourceImporter {
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
    public SyncResponse importFrom(final Resource resource) throws IOException {
        final Stream<List<ImdbEntry>> partition = parseAndPartition(resource);
        return partition.map(this::importFrom).reduce(SyncResponse::combinedWith).get();
    }

    private Stream<List<ImdbEntry>> parseAndPartition(final Resource resource) throws IOException {
        final List<ImdbEntry> entries = parser.parse(resource);
        logger.info("Loaded {} entries and partitioned them into batches of {} entries", entries.size(), PARTITION_SIZE);
        return ListUtils.partition(entries, PARTITION_SIZE).stream();
    }

    protected abstract SyncResponse importFrom(List<ImdbEntry> entries);
}

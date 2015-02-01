package com.github.fingolfintek.trakt.parser;

import java.io.IOException;
import java.util.List;

import com.github.fingolfintek.trakt.model.ImdbEntry;
import com.googlecode.jcsv.CSVStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ImdbCsvParser implements ImdbParser {

    private static final CSVStrategy IMDB_STRATEGY = new CSVStrategy(',', '"', '#', true, true);
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final CsvReaderFactory readerFactory;

    @Autowired
    public ImdbCsvParser(final CsvReaderFactory readerFactory) {
        this.readerFactory = readerFactory;
    }

    @Override 
    public List<ImdbEntry> parse(final Resource resource) throws IOException {
        logger.info("Parsing IMDB file {}", resource.getFile());
        return readerFactory.createReader(ImdbEntry.class, resource, IMDB_STRATEGY).readAll();
    }
}

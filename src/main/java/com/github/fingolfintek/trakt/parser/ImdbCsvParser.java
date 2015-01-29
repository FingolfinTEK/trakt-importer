package com.github.fingolfintek.trakt.parser;

import java.io.IOException;
import java.util.List;

import com.github.fingolfintek.trakt.model.ImdbEntry;
import com.googlecode.jcsv.CSVStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ImdbCsvParser implements ImdbParser {

    public static final CSVStrategy IMDB_STRATEGY = new CSVStrategy(',', '"', '#', true, true);
    private final CsvReaderFactory readerFactory;

    @Autowired
    public ImdbCsvParser(final CsvReaderFactory readerFactory) {
        this.readerFactory = readerFactory;
    }

    @Override 
    public List<ImdbEntry> parse(final Resource resource) throws IOException {
        return readerFactory.createReader(ImdbEntry.class, resource, IMDB_STRATEGY).readAll();
    }
}

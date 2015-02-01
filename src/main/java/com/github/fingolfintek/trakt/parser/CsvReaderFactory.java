package com.github.fingolfintek.trakt.parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class CsvReaderFactory {

    private final ValueProcessorProvider provider;

    public CsvReaderFactory() {
        this(new ValueProcessorProvider());
    }

    public CsvReaderFactory(final ValueProcessorProvider provider) {
        this.provider = provider;
    }

    public <T> CSVReader<T> createReader(Class<T> type, Resource resource) throws IOException {
        final CSVStrategy strategy = CSVStrategy.UK_DEFAULT;
        return createReader(type, resource, strategy);
    }

    public <T> CSVReader<T> createReader(final Class<T> type, final Resource resource, final CSVStrategy strategy) throws IOException {
        final Reader reader = new InputStreamReader(resource.getInputStream());
        final AnnotationEntryParser<T> entryParser = new AnnotationEntryParser<>(type, provider);
        final CSVReaderBuilder<T> csvReaderBuilder = new CSVReaderBuilder<>(reader);
        return csvReaderBuilder.entryParser(entryParser).strategy(strategy).build();
    }
}

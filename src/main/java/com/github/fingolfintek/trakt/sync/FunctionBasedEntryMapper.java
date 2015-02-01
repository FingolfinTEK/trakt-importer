package com.github.fingolfintek.trakt.sync;

import java.util.function.Function;

public class FunctionBasedEntryMapper<EntryType, ResultType> implements EntryMapper<EntryType, ResultType> {

    private final Function<EntryType, ResultType> mapper;

    public <V> FunctionBasedEntryMapper(Function<EntryType, V> intermediateMapper, Function<V, ResultType> resultMapper) {
        mapper = intermediateMapper.andThen(resultMapper);
    }

    @Override
    public ResultType map(final EntryType entry) {
        return mapper.apply(entry);
    }
}

package com.github.fingolfintek.trakt.sync;

import java.util.function.Function;

@FunctionalInterface
public interface EntryMapper<EntryType, ResultType> {
    
    default Function<EntryType, ResultType> mapper() {
        return this::map;
    }
    
    ResultType map(EntryType entry);        
        
}

package com.github.fingolfintek.trakt.parser;

import java.io.IOException;

import org.springframework.core.io.Resource;

public interface ResourceParser<ParseType> {

    ParseType parse(Resource resource) throws IOException;
}

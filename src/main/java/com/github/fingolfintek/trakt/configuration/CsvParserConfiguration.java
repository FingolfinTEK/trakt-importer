package com.github.fingolfintek.trakt.configuration;

import com.googlecode.jcsv.reader.CSVReader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(CSVReader.class)
@ComponentScan("com.github.fingolfintek.trakt.parser")
public class CsvParserConfiguration {

}

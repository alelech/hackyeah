package pl.hackyeah.hackyeah.parser;

import java.util.Arrays;
import java.util.List;

public class InitialCsvResult {

    private final List<String> parsedHeaders;

    public InitialCsvResult(String[] headers) {
        parsedHeaders = Arrays.asList(headers);
    }

    public List<String> getParsedHeaders() {
        return parsedHeaders;
    }
}

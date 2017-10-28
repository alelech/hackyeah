package pl.hackyeah.hackyeah.parser;

import java.util.Arrays;
import java.util.List;

public class InitialCsvResult {

    private final List<String> parsedHeaders;
    private final List<List<String>> previewRows;

    public InitialCsvResult(String[] headers, List<List<String>> previewRows) {
        parsedHeaders = Arrays.asList(headers);
        this.previewRows = previewRows;
    }

    public List<String> getParsedHeaders() {
        return parsedHeaders;
    }

    public List<List<String>> getPreviewRows() {
        return previewRows;
    }
}

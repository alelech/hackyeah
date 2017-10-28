package pl.hackyeah.hackyeah;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PendingFile {

    private final List<String> headers;
    private final List<List<String>> rows;

    public PendingFile(String[] headers, List<String[]> rows) {
        this.headers = Arrays.asList(headers);
        this.rows = rows.stream().map(Arrays::asList).collect(Collectors.toList());
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<List<String>> getRows() {
        return rows;
    }
}

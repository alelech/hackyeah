package pl.hackyeah.hackyeah.parser;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InitialParserService {

    public InitialParserService() {
        settings = new CsvParserSettings();
        settings.setHeaderExtractionEnabled(true);
        settings.getFormat().setDelimiter(';');
        processor = new RowListProcessor();
        settings.setProcessor(processor);
        parser = new CsvParser(settings);
    }

    private final RowListProcessor processor;
    private final CsvParserSettings settings;
    private final CsvParser parser;

    public InitialCsvResult parse(InputStream inputStream) {
        parser.parse(inputStream);
        List<String[]> csvFile = processor.getRows();
        int limit = Math.min(11, csvFile.size());
        List<String[]> previewRows = csvFile.subList(0, limit);
        List<List<String>> result = previewRows.stream().map(Arrays::asList).collect(Collectors.toList());
        String[] headers = processor.getHeaders();
//        csvFile.forEach(row -> System.out.println(Arrays.toString(row)));
        return new InitialCsvResult(headers, result);
    }
}

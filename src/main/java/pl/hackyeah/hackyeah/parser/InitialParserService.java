package pl.hackyeah.hackyeah.parser;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

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
        String[] headers = processor.getHeaders();
        csvFile.forEach(row -> System.out.println(Arrays.toString(row)));
        return new InitialCsvResult(headers);
    }
}

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
        settings.setHeaderExtractionEnabled(true);
        settings.setProcessor(processor);
    }

    private final RowListProcessor processor = new RowListProcessor();
    private final CsvParserSettings settings = new CsvParserSettings();
    private final CsvParser parser = new CsvParser(settings);

    public InitialCsvResult parse(InputStream inputStream) {
        parser.parse(inputStream);
        List<String[]> csvFile = processor.getRows();
        String[] headers = processor.getHeaders();
        csvFile.forEach(row -> System.out.println(Arrays.toString(row)));
        return new InitialCsvResult(headers);
    }
}

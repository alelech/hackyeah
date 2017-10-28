package pl.hackyeah.hackyeah.parser;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Service
public class InitialParserService {

    private final CsvParser parser = new CsvParser(new CsvParserSettings());

    public void parse(InputStream inputStream) {
        List<String[]> csvFile = parser.parseAll(inputStream);
        csvFile.forEach(row -> System.out.println(Arrays.toString(row)));
    }
}

package pl.hackyeah.hackyeah;

import com.google.common.io.Resources;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.junit.Test;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class CsvParserTest {

    @Test
    public void testParsing() throws Exception {
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setDelimiter(';');
        CsvParser parser = new CsvParser(settings);
        URL dataUrl = Resources.getResource("data/dane wejściowe.csv");
        List<String[]> allRows = parser.parseAll(Resources.asCharSource(dataUrl, StandardCharsets.UTF_8).openBufferedStream());
        allRows.forEach(row-> System.out.println(Arrays.toString(row)));
    }
}

package pl.hackyeah.hackyeah;

import com.google.common.io.Resources;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CsvUploadTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldHandleUpload() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("csvFile", Resources.toByteArray(Resources.getResource("data/dane wejściowe.csv")));

        this.mvc.perform(fileUpload("/uploadTest").file(multipartFile))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"parsedHeaders\":[\"IdAdres\",\"UL\",\"NR_BUD\",\"data\",\"miejsce\",\"typ_miejsc\",\"stan_nawie\",\"oznakowani\",\"oswietleni\",\"warunki_at\",\"wypadek\",\"ilosc_ucze\",\"wiek_spraw\",\"pojazd_spr\",\"wiek_piesz\",\"lekko_rann\",\"ciezko_ran\",\"zabici\"]}"));
    }
}

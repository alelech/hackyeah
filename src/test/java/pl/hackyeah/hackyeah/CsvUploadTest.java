package pl.hackyeah.hackyeah;

import com.google.common.io.Resources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    public void shouldHandleUpload2() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("csvFile",
                "COL1;COL2\nval1,val2".getBytes());

        this.mvc.perform(fileUpload("/uploadTest").file(multipartFile))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"fileId\":1,\"parsedHeaders\":[\"COL1\",\"COL2\"],\"previewRows\":[[\"val1,val2\"]]}"));

        mvc.perform(post("/process/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"addressColumns\":[\"COL1\"]}"))
                .andExpect(status().isOk());
    }
}

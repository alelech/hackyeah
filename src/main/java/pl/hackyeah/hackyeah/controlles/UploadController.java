package pl.hackyeah.hackyeah.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import pl.hackyeah.hackyeah.parser.InitialParserService;

import java.io.IOException;

@Controller
public class UploadController {

    @Autowired
    private InitialParserService initialParserService;

    @RequestMapping("/")
    @ResponseBody
    String index() {
        return "hello blotter";
    }

    @RequestMapping("/uploadTest")
    @ResponseStatus(HttpStatus.OK)
    //TODO just post raw text ?
    void upload(@RequestParam("csvFile") MultipartFile csvFile) throws IOException {
        initialParserService.parse(csvFile.getInputStream());
    }
}

package pl.hackyeah.hackyeah.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.hackyeah.hackyeah.controlles.request.ProcessFileRequest;
import pl.hackyeah.hackyeah.jobs.FileProcessingService;
import pl.hackyeah.hackyeah.parser.InitialCsvResult;
import pl.hackyeah.hackyeah.parser.InitialParserService;

import java.io.IOException;

@Controller
public class UploadController {

    @Autowired
    private InitialParserService initialParserService;

    @Autowired
    private FileProcessingService fileProcessingService;

    @RequestMapping("/")
    String index() {
        return "uploadForm/index";
    }

    @RequestMapping("/uploadTest")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    InitialCsvResult upload(@RequestParam("csvFile") MultipartFile csvFile) throws IOException {
        return initialParserService.parse(csvFile.getInputStream());
    }

    @RequestMapping("/process/{fileId}")
    @ResponseStatus(HttpStatus.OK)
    void process(@PathVariable("fileId") long fileId, @RequestBody ProcessFileRequest request){
        fileProcessingService.process(fileId, request.getAddressColumns());
    }
}

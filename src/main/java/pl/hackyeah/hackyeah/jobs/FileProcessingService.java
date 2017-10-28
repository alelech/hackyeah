package pl.hackyeah.hackyeah.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FileProcessingService {

    private static final Logger log = LoggerFactory.getLogger(FileProcessingService.class);

    private final Random random = new Random();

    public long submitCsvFile(List<String[]> csvFile){
        long id = random.nextLong();
        log.info("Starting to process csv , jobId={}",id);
        return id;
    }
}

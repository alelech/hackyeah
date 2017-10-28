package pl.hackyeah.hackyeah.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FileProcessingService {

    private static final Logger log = LoggerFactory.getLogger(FileProcessingService.class);

    private final AtomicLong jobIdCounter = new AtomicLong();

    public long submitCsvFile(String[] headers, List<String[]> csvFile){
        long id = jobIdCounter.incrementAndGet();
        log.info("Starting to process csv , jobId={}",id);
        return id;
    }
}

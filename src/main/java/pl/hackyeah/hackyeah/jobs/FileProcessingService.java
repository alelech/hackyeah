package pl.hackyeah.hackyeah.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.hackyeah.hackyeah.PendingFile;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FileProcessingService {

    private static final Logger log = LoggerFactory.getLogger(FileProcessingService.class);

    private final AtomicLong jobIdCounter = new AtomicLong();
    private final Map<Long,PendingFile> pendingFiles = new ConcurrentHashMap<>();

    public long storeCsvFile(PendingFile pendingFile) {
        long id = jobIdCounter.incrementAndGet();
        pendingFiles.put(id, pendingFile);
        return id;
    }

    public void process(long fileId, List<String> addressColumns) {
        log.info("processing fileId={} with columns={}",fileId,addressColumns);
    }
}

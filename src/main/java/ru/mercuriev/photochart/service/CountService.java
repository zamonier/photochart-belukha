package ru.mercuriev.photochart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mercuriev.photochart.domain.Count;
import ru.mercuriev.photochart.domain.CountRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class CountService {

    private static final String ZONE_ID = "Europe/Moscow";

    private static final String COMMAND = "find /Users/Eugene/Pictures/фотки\\ с\\ Белухи -type f | wc -l";

    private static final Logger logger = LoggerFactory.getLogger(CountService.class);

    @Autowired
    private ProcessExecutor executor;

    @Autowired
    private CountRepository repo;

    public List<Count> list() {
        populateNewCount();
        return repo.findAll();
    }

    @Scheduled(cron = "* 1 * * * *")
    public void populateNewCount() {
        logger.info("count population starts");
        try {
            String output = executor.execute(COMMAND);
            LocalDate now = LocalDate.now(ZoneId.of(ZONE_ID));
            Count count = repo.findByTimestamp(now);
            if (count != null) {
                count.setCount(Integer.parseInt(output));
            } else {
                count = new Count(Integer.parseInt(output), now);
            }
            repo.save(count);
        } catch (IOException | InterruptedException e) {
            logger.error("can't populate", e);
        }
        logger.info("count population ends");
    }


}

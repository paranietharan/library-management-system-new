package com.alphacodes.librarymanagementsystem.configs;

import com.alphacodes.librarymanagementsystem.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {// for update fines this run every midnight and update amounts in database
    @Autowired
    private FineService fineService;

    @Scheduled(cron = "0 0 0 * * ?") // This cron expression means the task will run daily at midnight
    public void scheduleFineCalculation() {
        fineService.checkAndUpdateFines();
    }
}
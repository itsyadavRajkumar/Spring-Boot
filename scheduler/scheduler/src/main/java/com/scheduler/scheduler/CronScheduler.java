package com.scheduler.scheduler;

import com.scheduler.service.SayHello;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronScheduler {
    private final SayHello sayHello;

    public CronScheduler(SayHello sayHello) {
        this.sayHello = sayHello;
    }

    @Scheduled(cron = "*/5 * * * * *") // this cron for every 5 second
    public void demo() {
        sayHello.sayHello();
    }
}

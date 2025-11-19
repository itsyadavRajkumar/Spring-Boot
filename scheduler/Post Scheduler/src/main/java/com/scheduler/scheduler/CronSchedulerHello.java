package com.scheduler.scheduler;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CronSchedulerHello {
    private final RestTemplate restTemplate;

    public CronSchedulerHello(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void callAPi() {
        String url = "http://localhost:8080/v1/hello";
        String response = restTemplate.exchange(
                url, // url
                HttpMethod.GET, //method type
                HttpEntity.EMPTY, //body
                String.class //response
        ).getBody();

        System.out.println("Cron: " + response);
    }
}

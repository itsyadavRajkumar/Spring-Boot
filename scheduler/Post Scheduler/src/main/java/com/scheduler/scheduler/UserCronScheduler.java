package com.scheduler.scheduler;

import com.scheduler.payload.UserDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserCronScheduler {
    private final RestTemplate restTemplate;

    public UserCronScheduler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void callApi() {
        String url = "http://localhost:8080/v2/user";
        UserDto userDto = new UserDto();
        userDto.setName("Rajkumar");
        userDto.settMobile("9876543210");
        HttpEntity<UserDto> entity = new HttpEntity<>(userDto);
        UserDto response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                UserDto.class
        ).getBody();

        System.out.println(response.toString());
    }
}

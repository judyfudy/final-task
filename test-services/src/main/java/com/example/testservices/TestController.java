package com.example.testservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RestController
public class TestController {

    @GetMapping("/test")
    public String redirect() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/", String.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return "ALL IS OKAY!";
        }
        return "SOMETHING WENT WRONG";
    }
}

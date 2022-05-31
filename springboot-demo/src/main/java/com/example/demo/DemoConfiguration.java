package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DemoConfiguration {

    @Bean
    public WebClient webClient() {
        // TODO
        return WebClient.builder().build();
    }
}

package com.example.demo;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {

    @Autowired
    private WebClient webClient;

    @PostMapping("/hello")
    public String hello(@RequestBody String name) {
        return "Hello! " + name;
    }

    @GetMapping("/world/{id}")
    public ResponseEntity<Something> world(@PathVariable String id) {
        var res = new Something(id);
        res.setRes(id);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/test/{id}")
    public Something test(@PathVariable String id) {
        var res = new Something(id);
        res.setRes(id);
        return res;
    }

    // Publish a message
    // curl -X POST http://localhost:3601/v1.0/publish/order-pub-sub/orders -H "Content-Type:
    // application/json" -d '{"orderId": "100"}'
    @PostMapping("/pubMessage")
    public Mono<String> pubMessage(@RequestBody String message) {
        return webClient.post()
                .uri(URI.create("http://localhost:3500/v1.0/publish/kafka-pubsub/test"))
                .contentType(MediaType.APPLICATION_JSON).body(Mono.just(message), String.class)
                .retrieve().bodyToMono(String.class);
    }

}

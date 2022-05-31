package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @PostMapping(value = "/hello")
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

}

package br.com.guini.springcloud.serviceb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void test(@RequestParam("value") Long value) {
        if (value % 5 == 0) {
            throw new IllegalArgumentException("Erro");
        }
        log.info("OK");
    }
}

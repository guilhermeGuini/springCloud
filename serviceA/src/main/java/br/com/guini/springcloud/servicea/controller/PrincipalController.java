package br.com.guini.springcloud.servicea.controller;

import br.com.guini.springcloud.servicea.service.PrincipalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/principal")
public class PrincipalController {

    private final PrincipalService principalService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void principal(@RequestBody Long value) {
        log.info("Making request");
        principalService.create(value.toString());
        log.info("Request done");
    }
}

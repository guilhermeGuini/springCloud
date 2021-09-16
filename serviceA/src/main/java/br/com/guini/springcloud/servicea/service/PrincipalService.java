package br.com.guini.springcloud.servicea.service;

import br.com.guini.springcloud.servicea.config.ServiceBClient;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PrincipalService {

    private static final String BACKEND = "backendB";

    private final ServiceBClient serviceBClient;

    @Retry(name = BACKEND, fallbackMethod = "fallback")
    @CircuitBreaker(name = BACKEND, fallbackMethod = "fallback")
    @RateLimiter(name = BACKEND)
    @Bulkhead(name = BACKEND)
    public String create(String value) {
        serviceBClient.create(value);
        return "Criado";
    }

    public String fallback(String value, RuntimeException exception) {
        log.info("Error", exception);
        return "Error";
    }
}

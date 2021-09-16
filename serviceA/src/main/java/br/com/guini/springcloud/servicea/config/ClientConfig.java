package br.com.guini.springcloud.servicea.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean
    public ServiceBClient attendanceValidationIntegration() {
        return Feign.builder().target(ServiceBClient.class, "http://localhost:8081");
    }
}

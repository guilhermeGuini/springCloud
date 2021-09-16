package br.com.guini.springcloud.servicea.config;

import feign.Headers;
import feign.RequestLine;

@Headers("Accept: application/json")
public interface ServiceBClient {

    @Headers("Content-Type: application/json")
    @RequestLine("POST /test")
    void create(String value);
}

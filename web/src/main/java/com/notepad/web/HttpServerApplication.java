package com.notepad.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by YM on 2017/6/4.
 */

@SpringBootApplication
@ImportResource(locations = {"classpath:/answerbean-config.xml"})
public class HttpServerApplication {
    public static void main(String [] args) {
        SpringApplication.run(HttpServerApplication.class, args);
    }

}

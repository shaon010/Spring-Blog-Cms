package org.mpb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication // I want to go home earlier
public class BlogApplication{

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}

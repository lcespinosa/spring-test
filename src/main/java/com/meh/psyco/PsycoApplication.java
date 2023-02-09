package com.meh.psyco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PsycoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PsycoApplication.class, args);
    }

}

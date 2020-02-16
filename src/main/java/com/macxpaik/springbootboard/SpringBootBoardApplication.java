package com.macxpaik.springbootboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBoardApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtolls.restart.enabled", "false");
        System.setProperty("spring.devtolls.livereload.enabled", "true");
        SpringApplication.run(SpringBootBoardApplication.class, args);
    }

}

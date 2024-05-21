package com.dlut.pathviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PathViewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PathViewerApplication.class, args);
    }

}

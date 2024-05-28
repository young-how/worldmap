package com.dlut.pathviewer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com.dlut.pathviewer.mapper")    // 指定mpper文件所在位置
public class PathViewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PathViewerApplication.class, args);
    }

}

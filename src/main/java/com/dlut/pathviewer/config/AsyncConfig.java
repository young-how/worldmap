package com.dlut.pathviewer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.config
 * @className: async
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/21 14:35
 * @version: 1.0
 */
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(30);
        executor.setQueueCapacity(30);
        executor.setThreadNamePrefix("Async-");
        executor.initialize();
        return executor;
    }
}

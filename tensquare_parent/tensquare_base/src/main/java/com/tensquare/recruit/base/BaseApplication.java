package com.tensquare.recruit.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@Slf4j
@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
        log.info("BaseApplication 启动成功");
    }

    /**
     * IdWorker用于生成雪花ID
     * @return
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }
}


package com.tensquare.recruit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@Slf4j
@SpringBootApplication
public class RecruitApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecruitApplication.class,args);
        log.info("RecruitApplication 启动成功");
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

}

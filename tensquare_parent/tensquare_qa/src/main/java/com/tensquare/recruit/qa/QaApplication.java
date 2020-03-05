package com.tensquare.recruit.qa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@Slf4j
@SpringBootApplication
public class QaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class, args);
        log.info("QaApplication  启动成功");
    }

    @Bean
    public IdWorker idWorkker(){
        return new IdWorker(1, 1);
    }

}
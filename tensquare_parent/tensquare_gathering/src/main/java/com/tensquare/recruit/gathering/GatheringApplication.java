package com.tensquare.recruit.gathering;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import util.IdWorker;


/**
 * @EnableCaching  自spring版本3.1起加入了该注解。如果你使用了这个注解，那么你就不需要在XML文件中配置cache manager了;
 * 使用@EnableCaching注解时，会触发一个post processor，这会扫描每一个spring bean，查看是否已经存在注解对应的缓存;
 * 如果找到了，就会自动创建一个代理拦截方法调用，使用缓存的bean执行处理
 */
@Slf4j
@SpringBootApplication
@EnableCaching
public class GatheringApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatheringApplication.class, args);
        log.info("GatheringApplication 启动成功");
    }

    @Bean
    public IdWorker idWorkker(){
        return new IdWorker(1, 1);
    }
}

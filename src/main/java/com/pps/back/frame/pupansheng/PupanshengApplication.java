package com.pps.back.frame.pupansheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@springfox.documentation.swagger2.annotations.EnableSwagger2
@MapperScan(basePackages = "com.pps.back.frame.pupansheng.mapper")
@EnableAsync
@EnableScheduling
public class PupanshengApplication {

    public static void main(String[] args) {
        SpringApplication.run(PupanshengApplication.class, args);
    }

}

package com.pps.back.frame.pupansheng;

import com.pps.back.frame.pupansheng.core.datasource.MyBatisDataSourceProcessor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@springfox.documentation.swagger2.annotations.EnableSwagger2
@EnableAsync
@EnableScheduling
@Import(MyBatisDataSourceProcessor.class)
public class PupanshengApplication {

    public static void main(String[] args) {
        SpringApplication.run(PupanshengApplication.class, args);
    }

}

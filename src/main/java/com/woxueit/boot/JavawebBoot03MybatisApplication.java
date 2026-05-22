package com.woxueit.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.woxueit.boot.mapper")
public class JavawebBoot03MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavawebBoot03MybatisApplication.class, args);
    }

}

package com.sample.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.sample.test.dao") //扫描该包路径下的所有mapper
@SpringBootApplication
public class SpringbootHikaricpWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHikaricpWebApplication.class, args);
    }

}

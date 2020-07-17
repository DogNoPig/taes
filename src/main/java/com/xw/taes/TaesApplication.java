package com.xw.taes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xw.taes.dao")
public class TaesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaesApplication.class, args);
    }

}
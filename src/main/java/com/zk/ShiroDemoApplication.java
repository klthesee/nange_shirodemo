package com.zk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zk.mapper")
public class ShiroDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiroDemoApplication.class);
    }
}

package com.gulistore.maven.gulistoremanagerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.gulistore.maven.gulistoremanagerservice.mapper")
public class GulistoreManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulistoreManagerServiceApplication.class, args);
    }

}

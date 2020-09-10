package com.gulistore.maven.gulistoremanagerservice;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.gulistore.maven.gulistoremanagerservice.mapper")
public class GulistoreManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulistoreManagerServiceApplication.class, args);
    }


    @Bean
    public RedissonClient redisson() throws IOException {
        // 本例子使用的是yaml格式的配置文件，读取使用Config.fromYAML，如果是Json文件，则使用Config.fromJSON
        Config config = Config.fromYAML(GulistoreManagerServiceApplication.class.getClassLoader().getResource("redisson-config.yml"));
        return Redisson.create(config);
    }

}

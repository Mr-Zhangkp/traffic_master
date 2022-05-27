package com.zhang.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories(basePackages = "com.zhang.system.repository")//扫描 @Repository 注解
@EntityScan(basePackages = "com.zhang.system.info")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TrafficSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrafficSystemApplication.class, args);
    }

}

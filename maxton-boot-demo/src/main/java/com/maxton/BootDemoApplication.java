package com.maxton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description 启动类
 * @Author maxton.zhang
 * @Date 2019/10/31 11:32
 * @Version 1.0
 */
@SpringBootApplication
@EnableSwagger2
public class BootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class, args);
    }
}

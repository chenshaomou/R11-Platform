package org.rainboweleven.platform.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 *
 *  等价于以默认属性使用 @Configuration ， @EnableAutoConfiguration 和 @ComponentScan
 *  先不启动 DataSourceAutoConfiguration
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}

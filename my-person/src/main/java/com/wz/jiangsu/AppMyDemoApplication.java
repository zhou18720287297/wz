package com.wz.jiangsu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: FlinkTest
 * @author: wangzhou
 * @create: 2023-11-24 09:10
 * @description:
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.wz.jiangsu.mapper")
public class AppMyDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AppMyDemoApplication.class);
    }

}

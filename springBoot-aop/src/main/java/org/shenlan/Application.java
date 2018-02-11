package org.shenlan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wangwei on 2016/9/8.
 */
@SuppressWarnings("unused")
@SpringBootApplication
@ComponentScan(basePackages={"org.shenlan","com.yhbaoplog"})
public class Application {
    public static void main(String[] args){

        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
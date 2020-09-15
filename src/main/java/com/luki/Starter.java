package com.luki;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.luki.dao")
public class Starter {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Starter.class);
        //  Person p = (Person) run.getBean("getPerson");
        // System.out.println(p.getAge());
    }
}

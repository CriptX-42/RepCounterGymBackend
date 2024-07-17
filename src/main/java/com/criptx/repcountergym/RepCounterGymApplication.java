package com.criptx.repcountergym;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.criptx.repcountergym"})
public class RepCounterGymApplication {


    public static void main(String[] args) {
        SpringApplication.run(RepCounterGymApplication.class, args);
    }


}

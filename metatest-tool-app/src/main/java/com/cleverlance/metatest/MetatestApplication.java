package com.cleverlance.metatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories({"com.metatest.backend.jpa.repository.jpa"})
@EntityScan({"com.metatest.backend.jpa.repository.entity"})
@SpringBootApplication(scanBasePackages = {"com.metatest.backend", "com.metatest.chatgptrestclient","com.cleverlance.metatest"})
@ConfigurationPropertiesScan({"com.metatest.backend", "com.metatest.chatgptrestclient","com.cleverlance.metatest"})
public class MetatestApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(MetatestApplication.class, args);
        System.out.println(context);
    }

}

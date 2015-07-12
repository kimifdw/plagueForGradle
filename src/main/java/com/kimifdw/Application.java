package com.kimifdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by kimiyu on 15/7/10.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        ApplicationContext context = SpringApplication.run(Application.class, args);
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames){
            System.out.println(beanName);
        }
    }
}

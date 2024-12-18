package com.epicode.spring_w1_d2.configuration;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        Faker faker = new Faker(Locale.ITALIAN);
        return faker;
    }
}

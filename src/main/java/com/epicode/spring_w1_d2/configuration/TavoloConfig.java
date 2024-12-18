package com.epicode.spring_w1_d2.configuration;

import com.epicode.spring_w1_d2.entity.Tavolo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TavoloConfig {

    @Bean(name = "tavolo1")
    public Tavolo tavolo1() {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(1);
        return tavolo;
    }

    @Bean(name = "tavolo2")
    public Tavolo tavolo2() {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(2);
        return tavolo;
    }

    @Bean(name = "tavolo3")
    public Tavolo tavolo3() {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(3);
        return tavolo;
    }

    @Bean(name = "tavolo4")
    public Tavolo tavolo4() {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(4);
        return tavolo;
    }
}
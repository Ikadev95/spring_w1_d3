package com.epicode.spring_w1_d2.configuration;

import com.epicode.spring_w1_d2.entity.Bevanda;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BevandaConfig {

    @Bean
    public Bevanda cola() {
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Cola");
        bevanda.setCalorie(150);
        bevanda.setPrezzo(3.0);
        return bevanda;
    }

    @Bean
    public Bevanda aranciata() {
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Aranciata");
        bevanda.setCalorie(120);
        bevanda.setPrezzo(3.5);
        return bevanda;
    }

    @Bean
    public Bevanda limonata() {
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Limonata");
        bevanda.setCalorie(100);
        bevanda.setPrezzo(3.0);
        return bevanda;
    }

    @Bean
    public Bevanda tonica() {
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Tonica");
        bevanda.setCalorie(80);
        bevanda.setPrezzo(3.5);
        return bevanda;
    }

    @Bean
    public Bevanda gazzosa() {
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Gazzosa");
        bevanda.setCalorie(90);
        bevanda.setPrezzo(3.0);
        return bevanda;
    }

    @Bean
    public Bevanda acquaFrizzante() {
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Acqua Frizzante");
        bevanda.setCalorie(0);
        bevanda.setPrezzo(2.0);
        return bevanda;
    }

    @Bean
    public Bevanda acquaNaturale() {
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Acqua Naturale");
        bevanda.setCalorie(0);
        bevanda.setPrezzo(2.0);
        return bevanda;
    }
}
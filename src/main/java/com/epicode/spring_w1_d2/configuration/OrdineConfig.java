package com.epicode.spring_w1_d2.configuration;

import com.epicode.spring_w1_d2.entity.Ordine;
import com.epicode.spring_w1_d2.enums.StatoOrdineEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalTime;

@Configuration
public class OrdineConfig {

    @Bean
    @Scope("prototype")
    public Ordine ordine (){
        Ordine ordine = new Ordine();
        ordine.setOraAcquisizione(LocalTime.now());
        ordine.setStatoOrdineEnum(StatoOrdineEnum.IN_CORSO);
        return ordine;
    }
}


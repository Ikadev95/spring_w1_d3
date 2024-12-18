package com.epicode.spring_w1_d2.configuration;
import com.epicode.spring_w1_d2.entity.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ToppingConfig  {

    @Bean
    public Topping formaggio() {
        Topping formaggio = new Topping();
        formaggio.setNome("Formaggio");
        formaggio.setCalorie(250);
        formaggio.setPrezzo(1.50);
        return formaggio;
    }

    @Bean
    public Topping prosciutto() {
        Topping prosciutto = new Topping();
        prosciutto.setNome("Prosciutto");
        prosciutto.setCalorie(200);
        prosciutto.setPrezzo(2.00);
        return prosciutto;
    }

    @Bean
    public Topping cipolle() {
        Topping cipolle = new Topping();
        cipolle.setNome("Cipolle");
        cipolle.setCalorie(50);
        cipolle.setPrezzo(0.75);
        return cipolle;
    }

    @Bean
    public Topping ananas() {
        Topping ananas = new Topping();
        ananas.setNome("Ananas");
        ananas.setCalorie(60);
        ananas.setPrezzo(1.00);
        return ananas;
    }

    @Bean
    public Topping salame() {
        Topping salame = new Topping();
        salame.setNome("Salame");
        salame.setCalorie(300);
        salame.setPrezzo(2.50);
        return salame;
    }
}

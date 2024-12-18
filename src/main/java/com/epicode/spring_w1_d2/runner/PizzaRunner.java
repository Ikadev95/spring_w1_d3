package com.epicode.spring_w1_d2.runner;

import com.epicode.spring_w1_d2.entity.Pizza;
import com.epicode.spring_w1_d2.entity.Topping;
import com.epicode.spring_w1_d2.repository.PizzaRepo;
import com.epicode.spring_w1_d2.repository.ToppingRepo;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(3)
public class PizzaRunner implements ApplicationRunner {

    @Autowired
    private ObjectProvider<Pizza> pizzaProvider;

    @Autowired
    private PizzaRepo pizzaRepo;

    @Autowired
    private Faker faker;

    @Autowired
    private ToppingRepo toppingRepo;

    @Autowired
    private Topping formaggio;

    @Autowired
    private Topping prosciutto;

    @Autowired
    private Topping cipolle;

    @Autowired
    private Topping ananas;

    @Autowired
    private Topping salame;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (pizzaRepo.count() == 0) {

            Pizza margherita = pizzaProvider.getObject();
            margherita.setNome("Margherita");
            pizzaRepo.save(margherita);


            Pizza cipollePizza = pizzaProvider.getObject();
            cipollePizza.setNome("Cipolle");
            List<Topping> toppingsCipolle = new ArrayList<>();
            toppingsCipolle.add(cipolle);
            cipollePizza.setToppings(toppingsCipolle);
            cipollePizza.setCalorie(cipollePizza.getCalorie() + cipolle.getCalorie());
            cipollePizza.setPrezzo(cipollePizza.getPrezzo() + cipolle.getPrezzo());
            pizzaRepo.save(cipollePizza);


            Pizza ananasPizza = pizzaProvider.getObject();
            ananasPizza.setNome("Ananas");
            List<Topping> toppingsAnanas = new ArrayList<>();
            toppingsAnanas.add(ananas);
            toppingsAnanas.add(formaggio);
            ananasPizza.setToppings(toppingsAnanas);
            ananasPizza.setCalorie(cipollePizza.getCalorie() + ananas.getCalorie());
            ananasPizza.setPrezzo(cipollePizza.getPrezzo() + ananas.getPrezzo());
            pizzaRepo.save(ananasPizza);
        }
    }
}

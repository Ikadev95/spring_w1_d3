package com.epicode.spring_w1_d2.runner;

import com.epicode.spring_w1_d2.entity.Topping;
import com.epicode.spring_w1_d2.repository.ToppingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class ToppingsRunner implements ApplicationRunner {

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
        if (toppingRepo.count() == 0) {
            toppingRepo.save(formaggio);
            toppingRepo.save(prosciutto);
            toppingRepo.save(cipolle);
            toppingRepo.save(ananas);
            toppingRepo.save(salame);
        }
    }
}
package com.epicode.spring_w1_d2.runner;

import com.epicode.spring_w1_d2.entity.Bevanda;
import com.epicode.spring_w1_d2.repository.BevandaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class BevandeRunner implements ApplicationRunner {

    @Autowired
    private BevandaRepo bevandaRepo;

    @Autowired
    private Bevanda cola;

    @Autowired
    private Bevanda aranciata;

    @Autowired
    private Bevanda limonata;

    @Autowired
    private Bevanda tonica;

    @Autowired
    private Bevanda gazzosa;

    @Autowired
    private Bevanda acquaFrizzante;

    @Autowired
    private Bevanda acquaNaturale;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (bevandaRepo.count() == 0) {
            // Salva i singleton nel repository
            bevandaRepo.save(cola);
            bevandaRepo.save(aranciata);
            bevandaRepo.save(limonata);
            bevandaRepo.save(tonica);
            bevandaRepo.save(gazzosa);
            bevandaRepo.save(acquaFrizzante);
        }

    }
}
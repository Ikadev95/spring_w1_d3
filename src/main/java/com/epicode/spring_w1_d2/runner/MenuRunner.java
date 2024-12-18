package com.epicode.spring_w1_d2.runner;

import com.epicode.spring_w1_d2.entity.Menu;
import com.epicode.spring_w1_d2.entity.Ordine;
import com.epicode.spring_w1_d2.entity.Tavolo;
import com.epicode.spring_w1_d2.enums.StatoOrdineEnum;
import com.epicode.spring_w1_d2.enums.StatoTavoloEnum;
import com.epicode.spring_w1_d2.repository.MenuRepo;
import com.epicode.spring_w1_d2.services.OrdiniETavoliService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;

@Component
@RequiredArgsConstructor
@Order(4)
public class MenuRunner implements ApplicationRunner {

    private final MenuRepo menuRepo;
    private final Logger logger;
    private final OrdiniETavoliService service;
    private final ObjectProvider<Ordine> ordineProvider;

    @Qualifier("tavolo1")
    private final Tavolo tavolo1;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Menu> listaMenu = menuRepo.findAll();
        listaMenu.forEach(menu -> logger.info(menu.stampa()));

        List<Menu> ordineEl = listaMenu.stream()
                .limit(3)
                .toList();

        tavolo1.setCoperti(5);
        tavolo1.setStatoTavoloEnum(StatoTavoloEnum.OCCUPATO);
        Ordine ordine = ordineProvider.getObject();
        service.salvaTavoliEOrdini(tavolo1, ordine);
        ordine.setElementi(ordineEl);
        ordine.setCopertiEffettivi(3);
        ordine.setStatoOrdineEnum(StatoOrdineEnum.IN_CORSO);
        ordine.setImportoTot(ordine.calcolaImportoTotale());

        List<Ordine> ordini = service.getOrdini();
        ordini.forEach(or -> logger.info(or.stampa()));
    }
}
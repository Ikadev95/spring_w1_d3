package com.epicode.spring_w1_d2.service;

import com.epicode.spring_w1_d2.entity.Ordine;
import com.epicode.spring_w1_d2.entity.Tavolo;
import com.epicode.spring_w1_d2.enums.StatoOrdineEnum;
import com.epicode.spring_w1_d2.repository.OrdineRepo;
import com.epicode.spring_w1_d2.repository.TavoloRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class OrETavoliTest {

    @Autowired
    private TavoloRepo tavoloRepo;

    @Autowired
    private OrdineRepo ordineRepo;

    @Transactional
    @Test
    @DisplayName("Test per salvataggio e recupero ordini e tavoli")

        public void testSalvaTavoloOrdine () {
            Tavolo tavolo = new Tavolo();
            tavolo.setNumeroTavolo(7);
            tavolo.setCoperti(4);

            Ordine ordine = new Ordine();
            ordine.setCopertiEffettivi(4);
            ordine.setStatoOrdineEnum(StatoOrdineEnum.IN_CORSO);
            ordine.setImportoTot(100.0);

            tavoloRepo.save(tavolo);
            ordineRepo.save(ordine);

            assertNotNull(tavolo.getId());
            assertNotNull(ordine.getId());
            assertEquals(StatoOrdineEnum.IN_CORSO, ordine.getStatoOrdineEnum(), "Lo stato dell'ordine non corrisponde a IN_CORSO");
    }
}

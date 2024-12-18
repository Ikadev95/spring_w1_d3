package com.epicode.spring_w1_d2.service;

import com.epicode.spring_w1_d2.configuration.OrdineConfig;
import com.epicode.spring_w1_d2.configuration.TavoloConfig;

import com.epicode.spring_w1_d2.entity.Menu;
import com.epicode.spring_w1_d2.entity.Ordine;
import com.epicode.spring_w1_d2.entity.Tavolo;
import com.epicode.spring_w1_d2.enums.StatoOrdineEnum;
import com.epicode.spring_w1_d2.enums.StatoTavoloEnum;
import com.epicode.spring_w1_d2.repository.MenuRepo;
import com.epicode.spring_w1_d2.services.OrdiniETavoliService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class OrETavoliTest {

    @Autowired
    private OrdiniETavoliService ordiniETavoliService;

    @Autowired
    private OrdineConfig ordineConfig;

    @Autowired
    private TavoloConfig tavoloConfig;

    @Autowired
    private MenuRepo menuRepo;

    @Test
    @DisplayName("Test per salvataggio e recupero ordini e tavoli")
    public void testSalvaOrdineETavolo() {

        List<Menu> listaMenu = menuRepo.findAll();

        // Setup del Tavolo
        Tavolo tavolo = tavoloConfig.tavolo3();
        tavolo.setCoperti(4);
        tavolo.setStatoTavoloEnum(StatoTavoloEnum.LIBERO);

        // Setup dell'Ordine
        Ordine ordine = ordineConfig.ordine();
        ordine.setCopertiEffettivi(4);
        ordine.setStatoOrdineEnum(StatoOrdineEnum.IN_CORSO);
        List<Menu> ordineEl = listaMenu.stream()
                .limit(4)
                .toList();
        ordine.setElementi(ordineEl);

        // Calcola l'importo dell'ordine
        ordine.setImportoTot(ordine.calcolaImportoTotale());

        // Salva Tavolo e Ordine
        ordiniETavoliService.salvaTavoliEOrdini(tavolo, ordine);

        // Recupera gli ordini
        List<Ordine> ordini = ordiniETavoliService.getOrdini();

        // Verifiche
        assertFalse(ordini.isEmpty(), "La lista degli ordini non dovrebbe essere vuota");

        Ordine ordineSalvato = ordini.get(1);

        // Controlla che l'ordine salvato abbia le stesse proprietà
        assertEquals(4, ordineSalvato.getCopertiEffettivi(), "I coperti effettivi dell'ordine non corrispondono");
        assertEquals(StatoOrdineEnum.IN_CORSO, ordineSalvato.getStatoOrdineEnum(), "Lo stato dell'ordine dovrebbe essere IN_CORSO");
        assertEquals(ordine.getImportoTot(), ordineSalvato.getImportoTot(), 0.01, "L'importo totale calcolato è errato");
        assertEquals(tavolo.getNumeroTavolo(), ordineSalvato.getTavolo().getNumeroTavolo(), "Il tavolo associato all'ordine non corrisponde");

        // Verifica lo stato aggiornato del tavolo
        assertEquals(StatoTavoloEnum.OCCUPATO, tavolo.getStatoTavoloEnum(), "Lo stato del tavolo dovrebbe essere OCCUPATO dopo il salvataggio");
    }
}

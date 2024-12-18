package com.epicode.spring_w1_d2.services;

import com.epicode.spring_w1_d2.entity.Ordine;
import com.epicode.spring_w1_d2.entity.Tavolo;
import com.epicode.spring_w1_d2.repository.OrdineRepo;
import com.epicode.spring_w1_d2.repository.TavoloRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdiniETavoliService {
    private final TavoloRepo tavoloRepo;
    private final OrdineRepo ordineRepo;

    @Transactional
    public void salvaTavoliEOrdini(Tavolo t, Ordine o){
        tavoloRepo.save(t);
        ordineRepo.save(o);
        t.setOrdine(o);
        o.setTavolo(t);
    }

    public List<Ordine> getOrdini() {return ordineRepo.findAll();}
}

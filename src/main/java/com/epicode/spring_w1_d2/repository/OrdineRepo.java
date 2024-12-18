package com.epicode.spring_w1_d2.repository;

import com.epicode.spring_w1_d2.entity.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepo extends JpaRepository<Ordine, Long> {
}

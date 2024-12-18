package com.epicode.spring_w1_d2.repository;

import com.epicode.spring_w1_d2.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepo extends JpaRepository<Pizza, Long> {
}

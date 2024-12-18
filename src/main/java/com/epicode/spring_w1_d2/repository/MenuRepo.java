package com.epicode.spring_w1_d2.repository;

import com.epicode.spring_w1_d2.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepo extends JpaRepository <Menu, Long> {
}

package com.epicode.spring_w1_d2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Topping extends Menu {

    @ManyToMany(mappedBy = "toppings")
    private List<Pizza> pizze;
}
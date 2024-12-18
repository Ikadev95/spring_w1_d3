package com.epicode.spring_w1_d2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Pizza extends Menu {


    @ManyToMany
    @JoinTable(
            name = "pizza_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings;

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}

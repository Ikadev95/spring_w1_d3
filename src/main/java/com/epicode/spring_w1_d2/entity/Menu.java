package com.epicode.spring_w1_d2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome")
    protected String nome;
    @Column(name = "calorie")
    protected int calorie;
    @Column(name = "prezzo")
    protected double prezzo;

    public String stampa(){
        String s = "nome: " + this.nome + " prezzo: " + this.prezzo + " euro" + " calorie: " + this.calorie + "cal" ;
        return s;
    }


}
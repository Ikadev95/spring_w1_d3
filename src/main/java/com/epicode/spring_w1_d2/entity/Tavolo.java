package com.epicode.spring_w1_d2.entity;

import com.epicode.spring_w1_d2.enums.StatoTavoloEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@Table(name = "tavoli")
public class Tavolo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name ="numero_tavolo")
    private int numeroTavolo;

    @Column(name ="coperti")
    private int coperti;

    @Column(name="stato")
    private StatoTavoloEnum statoTavoloEnum;

    @OneToOne
    private Ordine ordine;

}
package com.yugiohcounter.yugiohcounter.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "situacion")
@Setter
@Getter
@JsonIgnoreProperties("estrategia")
public class Situacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private String impacto;

    @ManyToOne
    @JoinColumn(name = "estrategia_id")
    private Estrategia estrategia;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "situacion_counter",
            joinColumns = @JoinColumn(name="situacion_id"),
            inverseJoinColumns = @JoinColumn(name="carta_id")
    )
    private List<CartaCounter> cartas_counter;

    @OneToOne
    private CartaObjetivo cartaObjetivo;

    public Situacion(){
        this.cartas_counter = new ArrayList<>();
    }

    public Situacion( int id, String descripcion, List<CartaCounter> cartas) {
        this.id = id;
        this.descripcion = descripcion;
        this.cartas_counter = cartas;
    }

    public void addCartaCounter(CartaCounter carta){
        this.cartas_counter.add(carta);
    }


}

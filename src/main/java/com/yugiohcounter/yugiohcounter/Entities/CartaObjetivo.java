package com.yugiohcounter.yugiohcounter.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table
@ToString
public class CartaObjetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private String typo;
    private String imagen;


    public CartaObjetivo(String nombre, String descripcion, String typo, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.typo = typo;
        this.imagen = imagen;

    }

    public  CartaObjetivo(){
    }
}

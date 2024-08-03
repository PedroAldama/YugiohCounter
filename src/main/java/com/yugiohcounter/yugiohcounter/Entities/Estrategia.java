package com.yugiohcounter.yugiohcounter.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.dialect.pagination.FetchLimitHandler;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
public class Estrategia{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "estrategia", fetch = FetchType.LAZY)
    private List<Situacion> listaSituaciones;

    public Estrategia(){
        this.listaSituaciones = new ArrayList<>();
    }

}

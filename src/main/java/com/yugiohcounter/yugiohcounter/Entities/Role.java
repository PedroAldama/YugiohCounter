package com.yugiohcounter.yugiohcounter.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="roles")
@AllArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String name;

    @JsonIgnoreProperties({"users"})
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role(){
        this.users = new ArrayList<>();
    }


}

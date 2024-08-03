package com.yugiohcounter.yugiohcounter.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    private boolean enable;

    @PrePersist
    public void prePersist(){
        enable = true;
    }

    @Transient
    private boolean admin;

    @JsonIgnoreProperties({"users"})
    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints ={@UniqueConstraint(columnNames = {"user_id","role_id"})}
    )
    private List<Role> roles;

    public User(){
        this.roles = new ArrayList<>();
    }
}

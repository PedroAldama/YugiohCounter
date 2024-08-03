package com.yugiohcounter.yugiohcounter.Repositories;

import com.yugiohcounter.yugiohcounter.Entities.CartaObjetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaObjetivoRepository extends JpaRepository<CartaObjetivo, Long> {
    Optional<CartaObjetivo> findByNombre(String name);
}

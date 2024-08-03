package com.yugiohcounter.yugiohcounter.Repositories;

import com.yugiohcounter.yugiohcounter.Entities.CartaCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaCounterRepository extends JpaRepository<CartaCounter, Long> {
    Optional<CartaCounter> findByNombre(String name);
}

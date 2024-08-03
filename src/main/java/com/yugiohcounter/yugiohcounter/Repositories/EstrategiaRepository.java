package com.yugiohcounter.yugiohcounter.Repositories;

import com.yugiohcounter.yugiohcounter.Entities.Estrategia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstrategiaRepository extends JpaRepository<Estrategia, Long> {
    Optional<Estrategia> findByName(String name);
}

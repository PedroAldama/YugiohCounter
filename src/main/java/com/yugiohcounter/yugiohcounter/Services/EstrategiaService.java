package com.yugiohcounter.yugiohcounter.Services;

import com.yugiohcounter.yugiohcounter.Entities.Estrategia;

import java.util.List;
import java.util.Optional;

public interface EstrategiaService {
     Estrategia save(Estrategia estrategia);
     Optional<Estrategia> findByName(String name);
     Optional<Estrategia> findById(Long id);
     List<Estrategia> findAll();
}

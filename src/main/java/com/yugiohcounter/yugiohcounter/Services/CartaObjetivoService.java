package com.yugiohcounter.yugiohcounter.Services;

import com.yugiohcounter.yugiohcounter.Entities.CartaObjetivo;

import java.util.Optional;

public interface CartaObjetivoService {
    CartaObjetivo save(CartaObjetivo c);
    Optional<CartaObjetivo> findById(Long id);
    Optional<CartaObjetivo> findByName(String name);
}

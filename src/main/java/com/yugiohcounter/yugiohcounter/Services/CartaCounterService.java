package com.yugiohcounter.yugiohcounter.Services;

import com.yugiohcounter.yugiohcounter.Entities.CartaCounter;

import java.util.Optional;

public interface CartaCounterService {
    CartaCounter save(CartaCounter c);
    Optional<CartaCounter> findById(Long id);
    Optional<CartaCounter> findByNombre(String name);
}

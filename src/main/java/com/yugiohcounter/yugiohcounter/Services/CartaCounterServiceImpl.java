package com.yugiohcounter.yugiohcounter.Services;

import com.yugiohcounter.yugiohcounter.Entities.CartaCounter;
import com.yugiohcounter.yugiohcounter.Repositories.CartaCounterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartaCounterServiceImpl implements CartaCounterService{

    private CartaCounterRepository cartaCounterRepository;

    public CartaCounterServiceImpl(CartaCounterRepository cartaCounterRepository) {
        this.cartaCounterRepository = cartaCounterRepository;
    }

    @Transactional
    @Override
    public CartaCounter save(CartaCounter c) {
        return cartaCounterRepository.save(c);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CartaCounter> findById(Long id) {
        return cartaCounterRepository.findById(id);
    }

    @Override
    public Optional<CartaCounter> findByNombre(String name) {
        return cartaCounterRepository.findByNombre(name);
    }
}

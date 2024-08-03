package com.yugiohcounter.yugiohcounter.Services;

import com.yugiohcounter.yugiohcounter.Entities.CartaObjetivo;
import com.yugiohcounter.yugiohcounter.Repositories.CartaObjetivoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartaObjetivoServiceImpl implements CartaObjetivoService {

    private CartaObjetivoRepository cartaObjetivoRepository;

    public CartaObjetivoServiceImpl(CartaObjetivoRepository cartaObjetivoRepository) {
        this.cartaObjetivoRepository = cartaObjetivoRepository;
    }

    @Transactional
    @Override
    public CartaObjetivo save(CartaObjetivo c) {
        return cartaObjetivoRepository.save(c);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CartaObjetivo> findById(Long id) {
        return cartaObjetivoRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CartaObjetivo> findByName(String name) {
        return cartaObjetivoRepository.findByNombre(name);
    }
}

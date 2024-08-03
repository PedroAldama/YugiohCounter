package com.yugiohcounter.yugiohcounter.Services;

import com.yugiohcounter.yugiohcounter.Entities.Estrategia;
import com.yugiohcounter.yugiohcounter.Repositories.EstrategiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstrategiaServiceImpl implements EstrategiaService{

    private EstrategiaRepository estrategiaRepository;

    public EstrategiaServiceImpl(EstrategiaRepository estrategiaRepository){
        this.estrategiaRepository = estrategiaRepository;
    }

    @Override
    public Estrategia save(Estrategia estrategia) {
        return estrategiaRepository.save(estrategia);
    }

    @Override
    public Optional<Estrategia> findByName(String name) {
        return estrategiaRepository.findByName(name);
    }

    @Override
    public Optional<Estrategia> findById(Long id) {
        return estrategiaRepository.findById(id);
    }

    @Override
    public List<Estrategia> findAll() {
        return estrategiaRepository.findAll();
    }
}

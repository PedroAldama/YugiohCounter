package com.yugiohcounter.yugiohcounter.Services;

import com.yugiohcounter.yugiohcounter.DTO.DTOSituacion;
import com.yugiohcounter.yugiohcounter.Entities.CartaCounter;
import com.yugiohcounter.yugiohcounter.Entities.CartaObjetivo;
import com.yugiohcounter.yugiohcounter.Entities.Estrategia;
import com.yugiohcounter.yugiohcounter.Entities.Situacion;
import com.yugiohcounter.yugiohcounter.Repositories.CartaCounterRepository;
import com.yugiohcounter.yugiohcounter.Repositories.CartaObjetivoRepository;
import com.yugiohcounter.yugiohcounter.Repositories.EstrategiaRepository;
import com.yugiohcounter.yugiohcounter.Repositories.SituacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SituacionServiceImpl implements  SituacionService{

    private final SituacionRepository repository;
    private final CartaObjetivoRepository objetivoRepository;
    private final CartaCounterRepository counterRepository;
    private final EstrategiaRepository estrategiaRepository;

    @Override
    @Transactional
    public Situacion save(Situacion situacion) {
        return repository.save(situacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Situacion> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Situacion saveDto(DTOSituacion dtoSituacion) {
        Situacion situacion = new Situacion();
        situacion.setDescripcion(dtoSituacion.getDescripcionSituacion());
        Optional<CartaObjetivo> objetivo = objetivoRepository.findByNombre(dtoSituacion.getNameCartaObjetivo());
        if(objetivo.isPresent()){
            situacion.setCartaObjetivo(objetivo.orElseThrow());
        }
        dtoSituacion.getNamesCartasCounter().forEach(nombre ->{
            counterRepository.findByNombre(nombre).ifPresent(situacion::addCartaCounter);
        });

        Optional<Estrategia> estrategia =estrategiaRepository.findByName(dtoSituacion.getNameEstrategia());
        estrategia.ifPresent(situacion::setEstrategia);
        situacion.setImpacto(dtoSituacion.getImpacto());
        return repository.save(situacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Situacion> findByCartaObjetivo(String carta) {
        Optional<CartaObjetivo> cartaObjetivo = objetivoRepository.findByNombre(carta);
        if(cartaObjetivo.isPresent()){
            return repository.findByCartaObjetivo(cartaObjetivo.get());
        }
        return Optional.empty();
    }
}

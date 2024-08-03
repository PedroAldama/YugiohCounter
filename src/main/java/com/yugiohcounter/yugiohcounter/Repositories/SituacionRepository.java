package com.yugiohcounter.yugiohcounter.Repositories;

import com.yugiohcounter.yugiohcounter.Entities.CartaObjetivo;
import com.yugiohcounter.yugiohcounter.Entities.Situacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SituacionRepository extends CrudRepository<Situacion, Long>{

    Optional<Situacion> findById(Long id);
    Optional<Situacion> findByDescripcion(String descripcion);
    Optional<Situacion> findByCartaObjetivo(CartaObjetivo cartaObjetivo);
}

package com.yugiohcounter.yugiohcounter.Services;

import com.yugiohcounter.yugiohcounter.DTO.DTOSituacion;
import com.yugiohcounter.yugiohcounter.Entities.CartaObjetivo;
import com.yugiohcounter.yugiohcounter.Entities.Situacion;

import java.util.Optional;

public interface SituacionService {
     Situacion save(Situacion situacion);
     Optional<Situacion> findById(Long id);
     Situacion saveDto(DTOSituacion dtoSituacion);
     Optional<Situacion> findByCartaObjetivo(String carta);
}

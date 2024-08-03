package com.yugiohcounter.yugiohcounter.DTO;

import lombok.Data;

import java.util.List;

@Data
public class DTOSituacion {
    String descripcionSituacion;
    String nameCartaObjetivo;
    String nameEstrategia;
    String impacto;
    List<String> namesCartasCounter;
}

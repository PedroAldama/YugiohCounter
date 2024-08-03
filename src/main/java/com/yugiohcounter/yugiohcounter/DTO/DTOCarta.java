package com.yugiohcounter.yugiohcounter.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DTOCarta {
    private int id;
    private String nombre;
    private String tipo;
    private String imagen;
}

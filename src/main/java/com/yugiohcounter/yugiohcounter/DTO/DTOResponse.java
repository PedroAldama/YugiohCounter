package com.yugiohcounter.yugiohcounter.DTO;

import com.yugiohcounter.yugiohcounter.Entities.Situacion;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DTOResponse {
    String situacion;
    Situacion data;

}

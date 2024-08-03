package com.yugiohcounter.yugiohcounter.Controllers;

import com.yugiohcounter.yugiohcounter.DTO.DTOResponse;
import com.yugiohcounter.yugiohcounter.DTO.DTOSituacion;
import com.yugiohcounter.yugiohcounter.Entities.Situacion;
import com.yugiohcounter.yugiohcounter.Services.SituacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/situacion")
public class SituacionController {

    SituacionService situacionService;

    public SituacionController(SituacionService situacionService){
        this.situacionService = situacionService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> addSituacion(@RequestBody DTOSituacion DtoSituacion){
        return  ResponseEntity.ok(situacionService.saveDto(DtoSituacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSituacionById(@PathVariable Long id){
        Optional<Situacion> situacionOptional = situacionService.findById(id);
       if(situacionOptional.isPresent()){
           Situacion situacion = situacionOptional.get();
           DTOResponse response = DTOResponse.builder().situacion(situacion.getDescripcion()).data(situacion).build();
           return ResponseEntity.ok(response);
       }
       return ResponseEntity.notFound().build();
    }

    @GetMapping("/carta/{name}")
    public ResponseEntity<?> getSituacionByCardName(@PathVariable String name){
        Optional<Situacion> situacionOptional = situacionService.findByCartaObjetivo(name);
        if(situacionOptional.isPresent()){
            Situacion situacion = situacionOptional.get();
            DTOResponse response = DTOResponse.builder().situacion(situacion.getDescripcion()).data(situacion).build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}

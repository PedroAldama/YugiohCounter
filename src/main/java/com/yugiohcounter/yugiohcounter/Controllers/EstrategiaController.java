package com.yugiohcounter.yugiohcounter.Controllers;

import com.yugiohcounter.yugiohcounter.Entities.Estrategia;
import com.yugiohcounter.yugiohcounter.Services.EstrategiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/estrategia")
@CrossOrigin(origins = "http://localhost:4200")
public class EstrategiaController {

   private EstrategiaService estrategiaService;

   public EstrategiaController(EstrategiaService estrategiaService){
       this.estrategiaService = estrategiaService;
   }

   @GetMapping("/id/{id}")

   public ResponseEntity<Estrategia> getEstrategiaById(@PathVariable Long id){
       Optional<Estrategia> estrategiaOptional = estrategiaService.findById(id);
       return estrategiaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

   @GetMapping("/name/{name}")
   public ResponseEntity<Estrategia> getEstrategiaByName(@PathVariable String name){
       Optional<Estrategia> estrategiaOptional = estrategiaService.findByName(name);
       return estrategiaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

    @GetMapping
    public List<Estrategia> getEstrategiaList(){
       return estrategiaService.findAll();
    }
}

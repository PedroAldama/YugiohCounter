package com.yugiohcounter.yugiohcounter.Controllers;

import com.yugiohcounter.yugiohcounter.Entities.CartaCounter;
import com.yugiohcounter.yugiohcounter.Entities.CartaObjetivo;
import com.yugiohcounter.yugiohcounter.Services.CartaCounterService;
import com.yugiohcounter.yugiohcounter.Services.CartaObjetivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/cartas")
public class CartaController {

    CartaCounterService cartaCounterService;
    CartaObjetivoService cartaObjetivoService;

    public CartaController(CartaCounterService cartaCounterService, CartaObjetivoService cartaObjetivoService){
        this.cartaCounterService = cartaCounterService;
        this.cartaObjetivoService = cartaObjetivoService;
    }

    @GetMapping("/cartaObjetivo/id/{id}")
    public Optional<CartaObjetivo> getCartaObjetivoById(@PathVariable Long id){
        return cartaObjetivoService.findById(id);
    }
    @GetMapping("/cartaObjetivo/name/{name}")
    public Optional<CartaObjetivo> getCartaObjetivoByName(@PathVariable String name){
        return cartaObjetivoService.findByName(name);
    }

    @PostMapping("/cartaObjetivo/crear")
    public ResponseEntity<CartaObjetivo> addCartaObjetivo(@RequestBody CartaObjetivo cartaObjetivo){
        return ResponseEntity.ok(cartaObjetivoService.save(cartaObjetivo));
    }

    @PostMapping("/cartaCounter/crear")
    public ResponseEntity<CartaCounter> addCartaCounter(@RequestBody CartaCounter cartaCounter){
        return ResponseEntity.ok(cartaCounterService.save(cartaCounter));
    }



}

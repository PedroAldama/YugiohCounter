package com.yugiohcounter.yugiohcounter;

import com.yugiohcounter.yugiohcounter.Entities.CartaCounter;
import com.yugiohcounter.yugiohcounter.Entities.CartaObjetivo;
import com.yugiohcounter.yugiohcounter.Entities.Situacion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class YugiohCounterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(YugiohCounterApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        CartaObjetivo objetivo = new CartaObjetivo();
        objetivo.setId(1);
        objetivo.setNombre("Big Welcome");
        objetivo.setTypo("Trampa");

        CartaCounter cartaCounter = new CartaCounter();
        cartaCounter.setNombre("Ash Blossom");
        cartaCounter.setType("Monstruo");

        CartaCounter cartaCounter2 = new CartaCounter();
        cartaCounter2.setId(2);
        cartaCounter2.setNombre("Bella");
        cartaCounter2.setType("Monstruo");

        Situacion bigWelcome = new Situacion();
        bigWelcome.setId(1);
        bigWelcome.setDescripcion("Invocar del deck, mano o cementerio y luego levantar un mon" +
                "struo que controle a la mano");
        bigWelcome.setCartas_counter(Arrays.asList(cartaCounter,cartaCounter2));
        bigWelcome.setCartaObjetivo(objetivo);


        System.out.println("bigWelcome = " + bigWelcome.toString());
    }
}

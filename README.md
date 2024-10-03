## Table of Contents
1. [General Info](#general-info)
2. [Technologies](#technologies)
3. [FAQs](#faqs)
### General Info
***
Una API diseñada para ayudar a los jugadores de Yu-Gi-Oh! TCG a contrarrestar estrategias específicas funcionaría como una herramienta que ofrece recomendaciones de cartas basadas en situaciones del juego o enfrentamientos comunes.

La API evaluaría la situación con base en una base de datos de cartas y efectos. Esto incluiría:
Efectos de cartas que pueden neutralizar o contrarrestar amenazas específicas.
Sugerencias basadas en cartas de side deck, hand traps, y cartas que pueden ser útiles en ese escenario.
Analizar sinergias entre las cartas del jugador y las recomendaciones para maximizar su efectividad.

## Technologies
***
Lista de tecnologias usadas en el proyecto:
* [Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html): Version 17 
* [Spring Boot](https://start.spring.io/): Version 3.3.4
* [Spring Security](https://spring.io/projects/spring-security): Version 3.3.1
* [MYSQL](https://dev.mysql.com/downloads/installer/): Version 8.0.33
* [JWT](https://jwt.io/) Version 0.12.6
* [MAVEN](https://maven.apache.org/)

## FAQs
***
1. **A quienes va dirigido el proyecto?**
_Este tipo de API es útil tanto para jugadores casuales como competitivos, ya que brinda asistencia estratégica y ayuda a prepararse mejor para torneos o enfrentamientos difíciles._ 

2. __En que casos es util consultar esta api?__ 
_Los jugadores pueden ingresar información sobre la situación del juego que enfrentan, como:_
* Tipo de mazo o estrategia que enfrentan (por ejemplo, control, combo, stun, etc.).
* Cartas clave del oponente en el campo o en juego (como "Skill Drain", "Mystic Mine").
* Estrategias concretas (por ejemplo, Labrynth, Dragon Link, Sky Striker, etc.)

3. **Que respuesta me dara la api ante una consulta de como enfrentar X estrategia?**
La API generará una lista de cartas recomendadas para esa situación en particular, así como una breve descripción de lo que se busca interrumpir o evitar. Las recomendaciones pueden incluir:
* Cartas de Interrupción: Hand traps como "Ash Blossom & Joyous Spring" para detener búsquedas o invocaciones clave.
* Cartas de Remoción: Hechizos/trampas como "Cosmic Cyclone" o "Twin Twisters" para destruir cartas problemáticas del campo.
* Cartas Defensivas: Efectos que permiten sobrevivir o ganar ventaja mientras se buscan soluciones (como "Dark Ruler No More" o "Evenly Matched").
4. **Que beneficios tiene para un jugador casual?**
Ayuda a los jugadores a encontrar las mejores cartas para contrarrestar la estrategia de su oponente, mejorando su comprensión del juego y brindándoles más opciones de respuesta ante diferentes situaciones.

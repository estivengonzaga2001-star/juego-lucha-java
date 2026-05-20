package com.juego.patrones.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtaqueFuerteTest {

    @Test
    void testCalcularDano() {
        AtaqueFuerte ataque = new AtaqueFuerte();

        int dano = ataque.calcularDano();

        assertTrue(dano >= 25 && dano <= 45);
    }
}

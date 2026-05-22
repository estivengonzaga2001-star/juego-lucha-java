package com.juego.patrones.factory;

import com.juego.patrones.strategy.AtaqueEstandar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtaqueEstandarTest {

    @Test
    void testCalcularDano() {
        AtaqueEstandar ataque = new AtaqueEstandar();

        int dano = ataque.calcularDano();

        assertTrue(dano >= 10 && dano <= 30);
    }
}
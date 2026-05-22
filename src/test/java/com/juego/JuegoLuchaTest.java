package com.juego;

import com.juego.juego.JuegoLucha;

import com.juego.model.Personaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoLuchaTest {

    @Test
    void testJuegoCompleto() {

        Personaje jugador1 = new Personaje("Ryu");
        Personaje jugador2 = new Personaje("Ken");

        JuegoLucha juego = new JuegoLucha(jugador1, jugador2);

        juego.iniciarPelea();

        assertTrue(
                jugador1.getPuntosDeVida() == 0 ||
                jugador2.getPuntosDeVida() == 0
        );
    }

    @Test
    void testJugadorSigueVivo() {

        Personaje jugador = new Personaje("SubZero");

        assertTrue(jugador.estaVivo());
    }

    @Test
    void testRecibirDano() {

        Personaje jugador = new Personaje("Scorpion");

        jugador.recibirDano(50);

        assertEquals(50, jugador.getPuntosDeVida());
    }

    @Test
    void testMorir() {

        Personaje jugador = new Personaje("Raiden");

        jugador.recibirDano(200);

        assertFalse(jugador.estaVivo());
    }
}
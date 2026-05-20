package com.juego.model;

import com.juego.patrones.strategy.EstrategiaAtaque;
import com.juego.patrones.factory.CreadorPersonajes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonajeTest {
    private Personaje personaje;

    @BeforeEach
    void setUp() {
        personaje = new Personaje("Luchador");
    }

    @Test
    @DisplayName("Debe crear personaje con 100 HP")
    void testCreacionPersonaje() {
        assertEquals("Luchador", personaje.getNombre());
        assertEquals(100, personaje.getPuntosDeVida());
        assertTrue(personaje.estaVivo());
    }

    @Test
    @DisplayName("Debe reducir HP al recibir da�o")
    void testRecibirDano() {
        personaje.recibirDano(30);
        assertEquals(70, personaje.getPuntosDeVida());
    }

    @Test
    @DisplayName("HP no debe ser negativo")
    void testHpNoNegativo() {
        personaje.recibirDano(150);
        assertEquals(0, personaje.getPuntosDeVida());
        assertFalse(personaje.estaVivo());
    }

    @Test
    @DisplayName("Uso de Mockito para fijar dano en el ataque")
    void testAtaqueConMock() {
        Personaje oponente = new Personaje("Oponente");
        EstrategiaAtaque ataqueMock = Mockito.mock(EstrategiaAtaque.class);
        when(ataqueMock.calcularDano()).thenReturn(20);
        personaje.setEstrategiaAtaque(ataqueMock);
        personaje.atacar(oponente);
        assertEquals(80, oponente.getPuntosDeVida());
    }

    @Test
    @DisplayName("Validar que la fabrica cree correctamente los personajes")
    void testFabricaPersonajes() {
        CreadorPersonajes fabrica = new CreadorPersonajes();
        Personaje p = fabrica.crearPersonaje("Estandar", "Ryu");
        assertEquals("Ryu", p.getNombre());
    }
}

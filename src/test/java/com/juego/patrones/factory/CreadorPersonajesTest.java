package com.juego.patrones.factory;

import com.juego.model.Personaje;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreadorPersonajesTest {

    @Test
    void testCrearPersonajeEstandar() {

        CreadorPersonajes fabrica = new CreadorPersonajes();

        Personaje personaje =
                fabrica.crearPersonaje("Estandar", "Ryu");

        assertEquals("Ryu", personaje.getNombre());
    }

    @Test
    void testCrearPersonajeAvanzado() {

        CreadorPersonajes fabrica = new CreadorPersonajes();

        Personaje personaje =
                fabrica.crearPersonaje("Avanzado", "Ken");

        assertEquals("Ken", personaje.getNombre());
    }
}
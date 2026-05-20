package com.juego.patrones.factory;

import com.juego.model.Personaje;
import com.juego.patrones.strategy.AtaqueFuerte;
import com.juego.patrones.strategy.AtaqueEstandar;

public class CreadorPersonajes extends PersonajeFactory {
    @Override
    public Personaje crearPersonaje(String tipo, String nombre) {
        Personaje personaje = new Personaje(nombre);
        if (tipo.equalsIgnoreCase("Avanzado") || tipo.equalsIgnoreCase("Guerrero")) {
            personaje.setEstrategiaAtaque(new AtaqueFuerte());
        } else {
            personaje.setEstrategiaAtaque(new AtaqueEstandar());
        }
        return personaje;
    }
}
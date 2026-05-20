package com.juego.model;

import com.juego.patrones.strategy.EstrategiaAtaque;
import com.juego.patrones.strategy.AtaqueEstandar;

public class Personaje {

    private String nombre;
    private int puntosDeVida;
    private EstrategiaAtaque estrategiaAtaque;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100;
        this.estrategiaAtaque = new AtaqueEstandar();
    }

    public void setEstrategiaAtaque(EstrategiaAtaque estrategiaAtaque) {
        this.estrategiaAtaque = estrategiaAtaque;
    }

    public void atacar(Personaje oponente) {
        int dano = this.estrategiaAtaque.calcularDano();

        oponente.recibirDano(dano);

        System.out.println(
            this.nombre + " ataca a "
            + oponente.getNombre()
            + " causando "
            + dano
            + " puntos de dano."
        );
    }

    public void recibirDano(int dano) {

        if (dano < 0) {
            return;
        }

        this.puntosDeVida -= dano;

        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
        }
    }

    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }
}
package com.juego.patrones.strategy;
import java.util.Random;

public class AtaqueFuerte implements EstrategiaAtaque {
    private Random rand = new Random();

    @Override
    public int calcularDano() {
        return rand.nextInt(21) + 25; 
    }
}

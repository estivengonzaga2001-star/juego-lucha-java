package com.juego.juego;

import com.juego.model.Personaje;
import com.juego.patrones.factory.CreadorPersonajes;
import java.util.Scanner;

public class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    public JuegoLucha(Personaje jugador1, Personaje jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void iniciarPelea() {
        System.out.println("La pelea comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "\n");
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            System.out.println("Turno de " + jugador1.getNombre() + ". Puntos de vida de " + jugador2.getNombre() + ": " + jugador2.getPuntosDeVida());
            jugador1.atacar(jugador2);
            System.out.println(jugador2.getNombre() + " ahora tiene " + jugador2.getPuntosDeVida() + " puntos de vida.\n");
            if (!jugador2.estaVivo()) break;

            System.out.println("Turno de " + jugador2.getNombre() + ". Puntos de vida de " + jugador1.getNombre() + ": " + jugador1.getPuntosDeVida());
            jugador2.atacar(jugador1);
            System.out.println(jugador1.getNombre() + " ahora tiene " + jugador1.getPuntosDeVida() + " puntos de vida.\n");
        }
        if (jugador1.estaVivo()) {
            System.out.println("?? " + jugador1.getNombre() + " ha ganado la pelea.");
        } else {
            System.out.println("?? " + jugador2.getNombre() + " ha ganado la pelea.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreadorPersonajes fabrica = new CreadorPersonajes();

        System.out.print("Introduce el nombre del jugador 1: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Seleccione tipo para jugador 1 (Estandar / Avanzado): ");
        String tipo1 = scanner.nextLine();
        Personaje j1 = fabrica.crearPersonaje(tipo1, nombre1);

        System.out.print("Introduce el nombre del jugador 2: ");
        String nombre2 = scanner.nextLine();
        System.out.print("Seleccione tipo para jugador 2 (Estandar / Avanzado): ");
        String tipo2 = scanner.nextLine();
        Personaje j2 = fabrica.crearPersonaje(tipo2, nombre2);

        JuegoLucha juego = new JuegoLucha(j1, j2);
        juego.iniciarPelea();
        scanner.close();
    }
}

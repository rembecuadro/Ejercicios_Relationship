package Services;

import Entities.Juego;
import Entities.Jugador;
import Entities.RevolverDeAgua;
import java.util.ArrayList;

public class JuegoServicio {

    RevolverDeAguaServicio rdas = new RevolverDeAguaServicio();
    JugadorServicio js = new JugadorServicio();
    RevolverDeAgua R1 = rdas.crearRevolver();
    ArrayList<Jugador> jugadores = js.fabricaJugadores();

    public void crearJuego() {

        rdas.llenarRevolver(R1);

        llenarJuego(R1, jugadores);
    }

    public void llenarJuego(RevolverDeAgua R1, ArrayList<Jugador> jugadores) {
        Juego J1 = new Juego();

        J1.setJugadores(jugadores);
        J1.setRevolver(R1);

    }

    public void ronda() {
        System.out.println("BIENVENIDO AL JUEGO DE LA VIDA RAATATAAT");
        System.out.println("DISCLAIMER: SOLO SE PUEDE CUANDO SON 6");

        js.disparo(R1, rdas);

        System.out.println("TERMINO EL JUEGO SE MURIO ALGUIEN");

    }

}

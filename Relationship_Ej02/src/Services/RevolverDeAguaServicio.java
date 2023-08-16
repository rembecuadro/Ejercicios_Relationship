package Services;

import Entities.RevolverDeAgua;

public class RevolverDeAguaServicio {

    public RevolverDeAgua crearRevolver() {
        RevolverDeAgua R1 = new RevolverDeAgua();
        return R1;
    }

    public void llenarRevolver(RevolverDeAgua R1) {
        R1.setPosicionActual((int) (Math.random() * 6));
        R1.setPosicionAgua((int) (Math.random() * 6));

        mostrar(R1);
    }

    public boolean mojar(RevolverDeAgua R1) {

        return (R1.getPosicionActual() == R1.getPosicionAgua());
    }

    public void siguienteChorro(RevolverDeAgua R1) {

        if (R1.getPosicionActual() == 5) {
            R1.setPosicionActual(0);
        } else {
            R1.setPosicionActual(R1.getPosicionActual() + 1);
        }

        mostrar(R1);
    }

    public void mostrar(RevolverDeAgua R1) {
        R1.toString();
    }

}

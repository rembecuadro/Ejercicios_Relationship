/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

//@author rembe
import Entidades.Baraja;
import Entidades.Carta;
import Enumeraciones.Palos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BarajaServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Carta> cartas = new ArrayList<>();
    ArrayList<Carta> cartasEntregadas = new ArrayList<>();

    public Baraja CrearBaraja() {
        Baraja B1 = new Baraja();

        for (int i = 0; i < 40; i++) {
            Carta C1 = new Carta();

            if (i < 10) {

                C1.setNumero(i + 1);
                C1.setPalo(Palos.ESPADA);

                if (i > 6) {
                    C1.setNumero(i + 3);
                }

            } else if (i < 20 && i > 9) {

                C1.setNumero(i - 9);
                C1.setPalo(Palos.BASTO);

                if (i > 16) {
                    C1.setNumero(i - 7);
                }
            } else if (i < 30 && i > 19) {

                C1.setNumero(i - 19);
                C1.setPalo(Palos.ORO);

                if (i > 26) {
                    C1.setNumero(i - 17);
                }
            } else if (i < 40 && i > 29) {

                C1.setNumero(i - 29);
                C1.setPalo(Palos.COPA);

                if (i > 36) {
                    C1.setNumero(i - 27);
                }
            }

            cartas.add(C1);
        }

        B1.setCartas(cartas);

        System.out.println(B1.toString());

        return B1;
    }

    public void menu() {
        Baraja B1 = CrearBaraja();
        boolean salir = false;

        while (!salir) {

            System.out.println("Seleccione que accion desea realizar:");
            System.out.println("1. Barajar");
            System.out.println("2. Siguiente carta");
            System.out.println("3. Cartas disponibles");
            System.out.println("4. Dar cartas");
            System.out.println("5. Mostrar cartas que ya salieron");
            System.out.println("6. Mostrar baraja");
            System.out.println("7. Salir");

            int rta = leer.nextInt();
            try {
                switch (rta) {
                    case 1:
                        barajar(B1);
                        break;
                    case 2:
                        siguienteCarta(B1);
                        break;
                    case 3:
                        cartasDisponibles(B1);
                        break;
                    case 4:
                        darCartas(B1);
                        break;
                    case 5:
                        cartasMonton();
                        break;
                    case 6:
                        mostrarBaraja(B1);
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese una opción valida del menú");
            }
        }
    }

    public void barajar(Baraja B1) {

        Collections.shuffle(B1.getCartas());

    }

    //siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
    //se haya llegado al final, se indica al usuario que no hay más cartas.
    public Carta siguienteCarta(Baraja B1) {
        Carta siguienteCarta = B1.getCartas().get(0);

        System.out.println("Salio la carta: " + siguienteCarta);

        cartasEntregadas.add(siguienteCarta);

        B1.getCartas().remove(0);

        return siguienteCarta;
    }

    //cartasDisponibles(): indica el número de cartas que aún se puede repartir.
    public void cartasDisponibles(Baraja B1) {
        System.out.println("La cantidad de cartas disponibles es: " + B1.getCartas().size());
    }

    //darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de
    //cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero
    //debemos indicárselo al usuario.
    public ArrayList<Carta> darCartas(Baraja B1) {
        System.out.println("Cuantas cartas desea sacar?");
        int cantidad = leer.nextInt();

        ArrayList<Carta> cartasDadas = new ArrayList<>();

        if (cantidad > B1.getCartas().size()) {
            System.out.println("No hay cartas suficientes :(");
        } else {
            for (int i = 0; i < cantidad; i++) {
                siguienteCarta(B1);
            }
        }

        return cartasDadas;
    }

    //cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
    //indicárselo al usuario
    public void cartasMonton() {
        if (cartasEntregadas.isEmpty()) {
            System.out.println("No se ha repartido ninguna carta.");
        } else {
            for (Carta carta : cartasEntregadas) {
                System.out.println("[" + carta.getNumero() + " de " + carta.getPalo() + ']');
            }
        }
    }

    //mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y
    //luego se llama al método, este no mostrara esa primera carta.
    public void mostrarBaraja(Baraja B1) {
        System.out.println(B1.toString());
    }

}

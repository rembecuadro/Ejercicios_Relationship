/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relationship_ej_ex1;

import Entities.Perro;
import Services.Servicio;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author rembe
 */
public class Relationship_Ej_Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Perro perro1 = new Perro("Blaze", "Pastor Collie", 3, "Mediano");
        Perro perro2 = new Perro("Azula", "Huskie", 2, "Grande");
        Perro perro3 = new Perro("Filipo", "Cocker", 5, "Mediano");
        Perro perro4 = new Perro("Benji", "Labrador", 6, "Grande");
        Perro perro5 = new Perro("Crilin", "French Poodle", 4, "Pequeño");

        ArrayList<Perro> perros = new ArrayList();
        perros.add(perro1);
        perros.add(perro2);
        perros.add(perro3);
        perros.add(perro4);
        perros.add(perro5);

        //System.out.println(perros.toString());
        Servicio s = new Servicio();
        //s.mostrarConjuntoPerros();
        s.mostrarLista();
        //s.asignarMascota();
//        
//        Persona persona1 = new Persona("Remberto", "Cuadro", 40, 73190890, perros.get(0));
//        Persona persona2 = new Persona("Katerin", "Renteria", 34, 1047399336, perros.get(1));
//        Persona persona2 = new Persona("Alejandro", "Cuadro", 8, 1201123456, perros.get(1));
//        Persona persona2 = new Persona("Alisson", "Cuadro", 8, 1201456789, perros.get(1));

    }

    public void menu() {
        Baraja B1 = CrearBaraja();
        boolean salir = false;
        int rta = leer.nextInt();

        while (!salir) {
            System.out.println("Seleccione que accion desea realizar:");
            System.out.println("1. Barajar");
            System.out.println("2. Siguiente carta");
            System.out.println("3. Cartas disponibles");
            System.out.println("4. Dar cartas");
            System.out.println("5. Mostrar cartas que ya salieron");
            System.out.println("6. Mostrar baraja");
            System.out.println("7. Salir");

            try {
                switch (rta) {
                    case 1:
                        barajar(B1);
                        menu();
                        break;
                    case 2:
                        siguienteCarta(B1);
                        menu();
                        break;
                    case 3:
                        cartasDisponibles(B1);
                        menu();
                        break;
                    case 4:

                        menu();
                        break;
                    case 5:

                        menu();
                        break;
                    case 6:

                        menu();
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

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

//@author rembe
import Entities.Persona;
import Entities.Perro;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Servicio {

    private Scanner scan;
    private List<Persona> personas;
    private List<Perro> perros;
    String nombreTemporal;
    Integer idTemporal;

    public Servicio() {
        this.scan = new Scanner(System.in).useDelimiter("\n");
        this.personas = new ArrayList<>();
        this.perros = new ArrayList<>();
    }

    private void crearPerro() {

        System.out.print("Escriba el nombre de su perro: ");
        String nombre = scan.next();
        System.out.print("Cual es la raza de su perro: ");
        String raza = scan.next();
        System.out.print("Escriba la edad de su perro: ");
        Integer edad = scan.nextInt();
        System.out.print("Cual es el tamaño de su perro: ");
        String tamano = scan.next();
        perros.add(new Perro(nombre, raza, edad, tamano));
        System.out.print("El perro " + nombre + " se ha creado correctamente\n");
    }

    public void agregarPerros() {
        System.out.println("Cuantos perros desea agregar: ");
        int cantidad = scan.nextInt();
        for (int i = 0; i < cantidad; i++) {
            crearPerro();
        }
    }

    private void crearPersona(int i) {

        Persona p = new Persona();
        System.out.print("Escriba el nombre de la persona: ");
        p.setNombre(scan.next());
        System.out.print("Ahora su apellido: ");
        p.setApellido(scan.next());
        System.out.print("Digite la edad de la persona: ");
        p.setEdad(scan.nextInt());
        System.out.print("Digite el número de documento: ");
        p.setDocumento(scan.nextInt());
        System.out.print(p.getNombre() + " " + p.getApellido() + " se ha creado correctamente\n");
        personas.add(p);
    }

    public void agregarPersonas() {
        System.out.println("Cuantos personas desea agregar: ");
        int cantidad = scan.nextInt();
        for (int i = 0; i < cantidad; i++) {
            crearPersona(i);
        }

    }

    public void asignarMascota(List<Persona> personas, List<Perro> perros) {
        validarListaPersonas();
        validarListaPerros();
        if (validarListaPerros() && validarListaPersonas()) {
            
            
        } else {
            System.out.println("\nNo se puede asignar la mascota");
        }
        if (!validarListaPersonas()) {
            mostrarConjuntoPersonas();
        }
        if (!validarListaPerros()) {
            mostrarConjuntoPerros();
        }
    }

    public boolean validarListaPersonas() {
        boolean veriflp = false;
        if (!personas.isEmpty()) {
            veriflp = true;
            System.out.println("Ingrese el número del ID del usuario al cual desea asignar una mascota");
            idTemporal = scan.nextInt();
            for (Persona aux : personas) {
                if (Objects.equals(idTemporal, aux.getDocumento())) {
                    System.out.println("La ID ingresado es válido");
                } else {
                    System.out.println("La ID ingresada no es correcta");
                }
            }
        }
        return veriflp;
    }

    public boolean validarListaPerros() {
        boolean veriflm = false;
        if (!perros.isEmpty()) {
            veriflm = true;
            System.out.println("\nDigite el nombre del perro que desea asignar");
            nombreTemporal = scan.next();
            for (Perro aux : perros) {
                if (Objects.equals(nombreTemporal, aux.getNombre())) {
                    System.out.println("El nombre ingresado es válido");
                } else {
                    System.out.println("El nombre ingresado no es correcta");
                }
            }
        }
        return veriflm;
    }

    public void mostrarConjuntoPersonas() {
        if (!personas.isEmpty()) {
            System.out.println(personas.toString());
        } else {
            System.out.println("\nNo hay usuarios registrados en el sistema");
        }
    }

    public void mostrarConjuntoPerros() {
        if (!perros.isEmpty()) {
            System.out.println(perros.toString());
        } else {
            System.out.println("\nNo hay mascotas en el inventario");
        }

    }

    public void mostrarLista() {
        boolean salir = false;
        int var;
        while (!salir) {
            System.out.println("\nTienda veterinaria: La Mascota Huerfana");
            System.out.println("Escoja una opción");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Crear Mascota");
            System.out.println("3. Ver Usuarios");
            System.out.println("4. Ver Mascotas");
            System.out.println("5. Asignar Mascotas");
            System.out.println("6. Salir");
            System.out.print("\nEscoja una opción: ");
            try {
                var = scan.nextInt();
                switch (var) {
                    case 1:
                        agregarPersonas();
                        break;
                    case 2:
                        agregarPerros();
                        break;
                    case 3:
                        mostrarConjuntoPersonas();
                        break;
                    case 4:
                        mostrarConjuntoPerros();
                        break;
                    case 5:
                        asignarMascota(personas, perros);
                        break;
                    case 6:
                        System.out.println("Hasta luego");
                        salir = true;
                        break;
                    default:
                        System.out.println("Ingrese un número válido");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Escriba 1. para ver personas, 2. para animales o 3. para salir");
            }
        }

    }
}

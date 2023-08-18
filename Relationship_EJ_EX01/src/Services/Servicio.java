/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

//@author rembe
import Entities.Persona;
import Entities.Mascota;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Servicio {

    private Scanner scan;
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Mascota> listaMascotas;
    private ArrayList<Mascota> listaMascotasAdoptadas;
    private String nombreTemporal;  //--> Variable que guardará temporalmente el nombre de la mascota que desea asignar
    private Integer idTemporal;     //--> Variable que guardará temporalmente el id del usuario al que se le va asignar la mascota.

    public Servicio() {
        this.scan = new Scanner(System.in).useDelimiter("\n");
        this.listaPersonas = new ArrayList<>();
        this.listaMascotas = new ArrayList<>();
        this.listaMascotasAdoptadas = new ArrayList<>();
        this.nombreTemporal = nombreTemporal;
        this.idTemporal = idTemporal;
    }

    private void crearMascota() {

        System.out.println("Escriba los datos de la mascota");
        System.out.print("NOMBRE: ");
        String nombre = scan.next();
        System.out.print("RAZA: ");
        String raza = scan.next();
        System.out.print("EDAD: ");
        Integer edad = scan.nextInt();
        System.out.print("TAMAÑO: ");
        String tamano = scan.next();
        listaMascotas.add(new Mascota(nombre, raza, edad, tamano)); // --> Se crea la mascota ya que se tienen todos los atibutos.
        System.out.print("\n" + nombre + " se ha sido ingresado al sistema satisfactoriamente\n");
    } // Método constructor de mascotas y creador de mascotas. 

    private void crearPersona() {

        Persona p = new Persona(); // --> Se crea un objeto Persona, con los atributos tomados a continuación, mas adelante de agregará el atributo mascota que será del tipo ArrayList
        System.out.println("Escriba los datos del usuario");
        System.out.print("NOMBRE: ");
        p.setNombre(scan.next());
        System.out.print("APELLIDO: ");
        p.setApellido(scan.next());
        System.out.print("EDAD: ");
        p.setEdad(scan.nextInt());
        System.out.print("DOCUMENTO DE IDENTIDAD ID: ");
        p.setDocumento(scan.nextInt());
        System.out.print("\n" + p.getNombre() + " " + p.getApellido() + " se ha creado correctamente\n");
        listaPersonas.add(p);
    } // Método constructor de personas. 

    public void agregarMascotas() { //Con este metodo se agregan n cantidad de mascotas solicitadas por el administrador
        System.out.print("Cuantos perros desea agregar: ");
        int cantidad = scan.nextInt();
        for (int i = 0; i < cantidad; i++) {
            crearMascota();
        }
    } // Funciona para crear varias mascotas. Es el que se utiliza para crearlas y agregarlas a una lista de mascotas.

    public void agregarPersonas() { //Con este método se agregan n cantidad de personas solicitadas por el administrador
        System.out.print("Cuantos personas desea agregar: ");
        int cantidad = scan.nextInt();
        for (int i = 0; i < cantidad; i++) {
            crearPersona();
        }
    } // Funciona para crear varias personas. Se utiliza para crearlas y agregarlas a una lista de personas

    private boolean validarListaPersonas() {
        boolean veriflp = false;
        if (!listaPersonas.isEmpty()) {
            veriflp = true;
            for (Persona aux : listaPersonas) {
                if (Objects.equals(idTemporal, aux.getDocumento())) {
                    System.out.println("La ID ingresado es válido");
                } else {
                    System.out.println("La ID ingresada no es correcta");
                }
            }
        }
        return veriflp;
    } // Método para validar si la lista de personas tiene objetos tipo Persona creados. Retorna false si está vacía

    private boolean validarListaMascotas() {
        boolean veriflm = false;
        if (!listaMascotas.isEmpty()) {
            veriflm = true;
            for (Mascota aux : listaMascotas) {
                if (Objects.equals(nombreTemporal, aux.getNombre())) {
                    System.out.println("El nombre ingresado es válido");
                } else {
                    System.out.println("El nombre ingresado no es correcta");
                }
            }
        }
        return veriflm;
    } // Método para validar si la lista de mascotas tiene objetos tipo Mascota creados. Retorna false si está vacía

    public void mostrarListaPersonas() {
        if (listaPersonas.isEmpty()) {
            System.out.println("\nNo hay usuarios registrados en el sistema");
        } else {
            System.out.println(listaPersonas.toString());
        }
    } // Muestra de las personas (y sus atributos) que pertenecen a la lista

    public void mostrarListaMascotas() {
        if (listaMascotas.isEmpty()) {
            System.out.println("\nNo hay mascotas en el inventario");
        } else {
            System.out.println(listaMascotas.toString());
        }
    } // Muestra de las mascotas (y sus atributos) que pertenecen a la lista

    public void mostrarListaMascotasAdoptadas() {
        if (listaMascotasAdoptadas.isEmpty()) {
            System.out.println("\nAún no se ha adoptado ninguna mascota :(");
        } else {
            System.out.println(listaMascotasAdoptadas.toString());
        }
    } // Muestra de las mascotas (y sus atributos) que pertenecen a la lista

    public void asignarMascota(ArrayList<Persona> listaPersonas, ArrayList<Mascota> listaMascotas) {

        if (validarListaMascotas() && validarListaPersonas()) { //Si las listas de personas y de mascotas tienen objetos creados, se puede asignar mascotas a las personas

            System.out.println("Ingrese el nombre de la mascota a adoptar");
            mostrarListaMascotas();
            System.out.print("--> ");
            nombreTemporal = scan.next();

            System.out.println("Ingrese el ID del usuario al que se le va asignar " + nombreTemporal);
            mostrarListaPersonas();
            System.out.print("--> ");
            idTemporal = scan.nextInt();

            for (Persona aux : listaPersonas) {
                for (Mascota dog : listaMascotas) {
                    aux.setMascota(listaMascotas);
                    System.out.println(dog.getNombre() + " ha sido asignado a " + aux.getNombre() + " con exito");
                    listaMascotasAdoptadas.add(dog);
                    listaMascotas.remove(dog);
                }
            }
        } else {
            System.out.println("\nNo se puede asignar la mascota");
        }
        if (!validarListaPersonas()) {
            mostrarListaPersonas();
        }
        if (!validarListaMascotas()) {
            mostrarListaMascotas();
        }
    } // Método para asignar una o mas mascotas a una persona.

    public void menu() {
        boolean salir = false;
        int var;
        while (!salir) {
            System.out.println("\nTienda veterinaria: La Mascota Huerfana\n");
            System.out.println("Escoja una opción");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Crear Mascota");
            System.out.println("3. Ver Usuarios");
            System.out.println("4. Ver Mascotas");
            System.out.println("5. Asignar Mascotas");
            System.out.println("6. Ver mascotas adoptadas");
            System.out.println("7. Salir");
            System.out.print("\nEscoja una opción: ");
            try {
                var = scan.nextInt();
                switch (var) {
                    case 1:
                        agregarPersonas();
                        break;
                    case 2:
                        agregarMascotas();
                        break;
                    case 3:
                        mostrarListaPersonas();
                        break;
                    case 4:
                        mostrarListaMascotas();
                        break;
                    case 5:
                        asignarMascota(listaPersonas, listaMascotas);
                        break;
                    case 6:
                        mostrarListaMascotasAdoptadas();
                        break;
                    case 7:
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

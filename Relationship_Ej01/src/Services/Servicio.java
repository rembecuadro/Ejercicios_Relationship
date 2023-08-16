/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

//@author rembe
import Entities.Persona;
import Entities.Perro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servicio {

    private Scanner scan;
    private List<Persona> persona;
    private List<Perro> perro;

    public Servicio() {
        this.scan = new Scanner(System.in).useDelimiter("\n");
        this.persona = new ArrayList<>();
        this.perro = new ArrayList<>();
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
        perro.add(new Perro(nombre, raza, edad, tamano));
        System.out.print("El perro " + nombre + " se ha creado correctamente\n");
    }
    
    public void agregarPerros(){
        System.out.println("Cuantos perros desea agregar: ");
        int cantidad = scan.nextInt();
        for (int i = 0; i < cantidad; i++) {
            crearPerro();
        }
        
    }

    private void crearPersona(int i) {

        System.out.print("Escriba el nombre de la persona: ");
        String nombre = scan.next();
        System.out.print("Ahora su apellido: ");
        String apellido = scan.next();
        System.out.print("Digite la edad de la persona: ");
        Integer edad = scan.nextInt();
        System.out.print("Digite el número de documento: ");
        Integer documento = scan.nextInt();
        persona.add(new Persona(nombre, apellido, edad, documento, perro.get(i)));
        System.out.print(nombre + " se ha creado correctamente\n");
    }
    
    public void agregarPersonas(){
        System.out.println("Cuantos personas desea agregar: ");
        int cantidad = scan.nextInt();
        agregarPerros();
        for (int i = 0; i < cantidad; i++) {
            
            crearPersona(i);
        }
        
    }
    
    public void mostrarConjunto(){
        agregarPersonas();
        for (Persona aux : persona) {
            System.out.println(aux);            
        }
    }

}

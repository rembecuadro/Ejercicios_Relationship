/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relationship_ej1;

import Entities.Perro;
import Entities.Persona;
import Services.Servicio;
import java.util.ArrayList;
import javax.print.PrintServiceLookup;

/**
 *
 * @author rembe
 */
public class Relationship_Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       
//        Perro perro1 = new Perro("Blaze", "Pastor Collie", 3, "mediano");
//        Perro perro2 = new Perro("Azula", "Huskie", 2, "Grande");
//        
//        ArrayList<Perro> perros = new ArrayList();
//        perros.add(perro1);
//        perros.add(perro2);
//   
//        Persona persona1 = new Persona("Remberto", "Cuadro", 40, 73190890, perros.get(0));
//        System.out.println(persona1.toString());
//        Persona persona2 = new Persona("Remberto", "Cuadro", 40, 73190890, perros.get(1));
//        System.out.println(persona2.toString());

        Servicio s = new Servicio();
        s.mostrarConjunto();
    }

}

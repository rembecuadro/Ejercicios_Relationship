/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relationship_ej_03;

import Servicios.BarajaServicio;
import java.util.InputMismatchException;

/**
 *
 * @author rembe
 */
public class Relationship_EJ_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BarajaServicio bs = new BarajaServicio();
//        try {
//            bs.menu();
//        } catch (InputMismatchException e) {
//            System.out.println("Valor equivocado");
//        }
        bs.menu();
    }

}

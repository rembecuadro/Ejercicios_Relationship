/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Entities;

//@author rembe
 
public class Perro {
    
    private String nombre;
    private String raza;
    private Integer edad;
    private String tamano;

    public Perro() {
    }

    public Perro(String nombre, String raza, Integer edad, String tamano) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTamaño() {
        return tamano;
    }

    public void setTamaño(String tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "\nNombre de la mascota= " + nombre + "\nRaza= " + raza + "\nEdad= " + edad + "\nTamaño= " + tamano+"\n";
    }

    

}

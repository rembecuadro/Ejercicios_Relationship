/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Entities;

//@author rembe

import java.util.ArrayList;

 
public class Persona {
    
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer documento;
    private ArrayList<Mascota> listaMascotas;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Integer edad, Integer documento, ArrayList<Mascota> listaMascotas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.listaMascotas = listaMascotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public ArrayList<Mascota> listaMascotas() {
        return listaMascotas;
    }

    public void setMascota(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    @Override
    public String toString() {
        return "\nPersona \nNombre= " + nombre +" "+ apellido + "\nEdad= " + edad + "\nID= " + documento + "\nMascota= " + listaMascotas;
    }
}

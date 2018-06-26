/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Maydali
 */
public class Contacto {

    private String nombre;
    private ArrayList numeros;

    public Contacto() {
    }

    public Contacto(String nombre, ArrayList numeros) {
        this.nombre = nombre;
        this.numeros = numeros;
    }

    public void eliminarNumero(int index) {
        getNumeros().remove(index);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList numeros) {
        this.numeros = numeros;
    }

}

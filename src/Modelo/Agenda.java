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
public class Agenda {
    private ArrayList<Contacto> contactos;

    public Agenda(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public Agenda() {
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
    
    
}

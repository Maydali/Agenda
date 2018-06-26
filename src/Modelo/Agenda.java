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

    private ArrayList<Contacto> contactos = new ArrayList<>();

    public Agenda() {
    }

    public void guardarContacto(Contacto contacto) {
        getContactos().add(contacto);
    }
      public void eliminarContacto(Contacto contacto){
        getContactos().remove(contacto);
    }
      public Contacto buscarContacto(int index){
            Contacto contactoSeleccionado = null;
        for(int i = 0; i< getContactos().size();i++){
            contactoSeleccionado = getContactos().get(index);
        }
        return contactoSeleccionado;
      }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

}

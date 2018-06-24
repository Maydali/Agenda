/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Control.ControlVistaContactos;
import Modelo.Agenda;
import Vista.VistaContactos;

/**
 *
 * @author Maydali
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
        Agenda agenda = new Agenda();
        VistaContactos vistaContactos = new VistaContactos();
        ControlVistaContactos controlContacto = new ControlVistaContactos(vistaContactos, agenda);
        controlContacto.iniciar();
    }

}

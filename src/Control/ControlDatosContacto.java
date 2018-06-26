/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Contacto;
import Vista.DatosContacto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

/**
 *
 * @author Maydali
 */
public class ControlDatosContacto implements ActionListener {

    DatosContacto datosContacto;
    Contacto contacto;
    DefaultListModel modelo = new DefaultListModel();

    public ControlDatosContacto(DatosContacto datosContacto, Contacto contacto) {
        this.datosContacto = datosContacto;
        this.contacto = contacto;
        DatosContacto.regresar.addActionListener(this);
    }

    public void iniciar() {
        datosContacto.setVisible(true);
        desplegarInformacion();
    }

    private void desplegarInformacion() {
        String nombre = contacto.getNombre();
        DatosContacto.nombre.setText(nombre);
        for (int i = 0; i < contacto.getNumeros().size(); i++) {
            modelo.addElement(contacto.getNumeros().get(i));
        }
        DatosContacto.numeros.setModel(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == DatosContacto.regresar) {
            datosContacto.setVisible(false);
        }
    }

}

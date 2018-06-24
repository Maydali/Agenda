/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Agenda;
import Modelo.Contacto;
import Vista.DatosContacto;
import Vista.VistaContactos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Maydali
 */
public class ControlDatosContacto implements ActionListener {

    DatosContacto datosContacto;
    Contacto contacto;
    Agenda agenda;
    DefaultListModel modelo = new DefaultListModel();
    ArrayList<Contacto> contactos = null;

    public ControlDatosContacto(DatosContacto datosContacto, Agenda agenda, Contacto contacto) {
        this.datosContacto = datosContacto;
        this.contacto = contacto;
        this.agenda = agenda;
        DatosContacto.Añadir.addActionListener(this);
        DatosContacto.Agregar.addActionListener(this);
        DatosContacto.Eliminar.addActionListener(this);
    }

    public void iniciar() {
        datosContacto.setVisible(true);
    }

    private void agendarContacto() {
        agenda.guardarContacto(contacto);
    }

    private void setDatos() {
        ArrayList numeros = new ArrayList();
        for (int i = 0; i < modelo.getSize(); i++) {
            numeros.add(modelo.getElementAt(i));
            System.out.println("Numero " + modelo.getElementAt(i));
        }
        contacto = new Contacto(DatosContacto.Nombre.getText(), numeros);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (DatosContacto.Añadir == e.getSource()) {
            setDatos();
            agendarContacto();
            VistaContactos vistaInicial = new VistaContactos();
            ControlVistaContactos contactosAnadidos = new ControlVistaContactos(vistaInicial, agenda);
            contactosAnadidos.contactosAnadidos();

            datosContacto.setVisible(false);
        }
        if (DatosContacto.Agregar == e.getSource()) {
            if (!DatosContacto.telefono.getText().equals("")) {
                String telefono = DatosContacto.telefono.getText();
                modelo.addElement(telefono);
                DatosContacto.telefonos.setModel(modelo);
                DatosContacto.telefono.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar el campo");
            }

        }
        if (DatosContacto.Eliminar == e.getSource()) {
            if (!DatosContacto.telefonos.isSelectionEmpty()) {
                int valor = DatosContacto.telefonos.getSelectedIndex();
                modelo.remove(valor);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar número");
            }
        }
    }
}

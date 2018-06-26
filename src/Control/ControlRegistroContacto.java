/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Agenda;
import Modelo.Contacto;
import Vista.RegistroContacto;
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
public class ControlRegistroContacto implements ActionListener {

    RegistroContacto datosContacto;
    Contacto contacto;
    Agenda agenda;
    DefaultListModel modelo = new DefaultListModel();
    ArrayList<Contacto> contactos = null;

    public ControlRegistroContacto(RegistroContacto datosContacto, Agenda agenda, Contacto contacto) {
        this.datosContacto = datosContacto;
        this.contacto = contacto;
        this.agenda = agenda;
        RegistroContacto.Añadir.addActionListener(this);
        RegistroContacto.Agregar.addActionListener(this);
        RegistroContacto.Eliminar.addActionListener(this);
    }

    public void iniciar() {
        datosContacto.setVisible(true);
    }

    public void actualizarContacto() {
        datosContacto.setVisible(true);
        RegistroContacto.Nombre.setText(contacto.getNombre());
        for (int i = 0; i < contacto.getNumeros().size(); i++) {
            modelo.addElement(contacto.getNumeros().get(i));
        }
        RegistroContacto.telefonos.setModel(modelo);
    }

    private String setDatos() {
        String accion = null;
        ArrayList numeros = new ArrayList();
        for (int i = 0; i < modelo.getSize(); i++) {
            numeros.add(modelo.getElementAt(i));
            System.out.println("Numero " + modelo.getElementAt(i));
        }
        if (!agenda.getContactos().isEmpty()) {

            if (agenda.getContactos().contains(contacto)) {
                accion = "actualizar";
                System.out.println("lo contiene");
                for (int i = 0; i < agenda.getContactos().size(); i++) {
                    System.out.println("tamaño" + agenda.getContactos().size());
                    System.out.println("contacto.getNombre()" + contacto.getNombre());
                    System.out.println("agenda.getContactos().get(i).getNombre()" + agenda.getContactos().get(i).getNombre());
                    if (contacto.getNombre().equals(agenda.getContactos().get(i).getNombre())) {

                        agenda.getContactos().get(i).setNombre(RegistroContacto.Nombre.getText());
                        agenda.getContactos().get(i).setNumeros(numeros);
                        System.out.println("Entró");

                    }
                }

            } else {
                accion = "guardar";
                contacto = new Contacto(RegistroContacto.Nombre.getText(), numeros);
            }

        } else {
            accion = "guardar";
            contacto = new Contacto(RegistroContacto.Nombre.getText(), numeros);
        }
        return accion;
    }

    private void agendarContacto(String accion) {
        if (accion.equals("actualizar")) {
            System.out.println("Contacto Actualizado");
        } else {
            agenda.guardarContacto(contacto);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (RegistroContacto.Añadir == e.getSource()) {
            String accion = setDatos();
            agendarContacto(accion);
            VistaContactos vistaInicial = new VistaContactos();
            ControlVistaContactos contactosAnadidos = new ControlVistaContactos(vistaInicial, agenda);
            contactosAnadidos.contactosAnadidos();

            datosContacto.setVisible(false);
        }
        if (RegistroContacto.Agregar == e.getSource()) {
            if (!RegistroContacto.telefono.getText().equals("")) {
                String telefono = RegistroContacto.telefono.getText();
                modelo.addElement(telefono);
                RegistroContacto.telefonos.setModel(modelo);
                RegistroContacto.telefono.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar el campo");
            }

        }
        if (RegistroContacto.Eliminar == e.getSource()) {
            if (!RegistroContacto.telefonos.isSelectionEmpty()) {
                int index = RegistroContacto.telefonos.getSelectedIndex();
                String numero = RegistroContacto.telefonos.getSelectedValue();
                for (int i = 0; i < agenda.getContactos().size(); i++) {
                    if (agenda.getContactos().get(i).getNumeros().contains(numero)) {
                        contacto.eliminarNumero(index);
                    }
                }
                modelo.remove(index);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar número");
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Agenda;
import Modelo.Contacto;
import Vista.DatosContacto;
import Vista.RegistroContacto;
import Vista.VistaContactos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Maydali
 */
public class ControlVistaContactos implements ActionListener {

    private VistaContactos vistaContactos;
    private ArrayList<Contacto> contactoArreglo = new ArrayList<>();
    private Agenda agenda;
    private Contacto contacto;
    private DefaultListModel modelo = new DefaultListModel();
    private JList contactos = new JList();

    public ControlVistaContactos() {
    }

    public ControlVistaContactos(VistaContactos vistaContactos, Agenda agenda) {
        this.vistaContactos = vistaContactos;
        this.agenda = agenda;
        VistaContactos.añadir.addActionListener(this);
    }

    public void iniciar() {
     
        vistaContactos.setVisible(true);

    }

    public void contactosAnadidos() {

        for (int j = 0; j < agenda.getContactos().size(); j++) {
            System.out.println("nombre" + agenda.getContactos().get(j).getNombre());
            modelo.addElement(agenda.getContactos().get(j).getNombre());
        }
        contactos.setModel(modelo);

        VistaContactos.panel.add(contactos, BorderLayout.CENTER);
        VistaContactos.panel.setLayout(new FlowLayout());
        JButton update = new JButton("Actualizar");
        update.addActionListener(this);
        update.setActionCommand("Actualizar");
        VistaContactos.panel.add(update, BorderLayout.SOUTH);
        JButton delete = new JButton("Borrar");
        delete.addActionListener(this);
        delete.setActionCommand("Borrar");
        VistaContactos.panel.add(delete, BorderLayout.SOUTH);
        //main_panel.add(southpanel, BorderLayout.SOUTH);
        //SwingUtilities.updateComponentTreeUI(VistaContactos.panel);
        VistaContactos.panel.updateUI();
        VistaContactos.panel.repaint();
        vistaContactos.setVisible(true);

        contactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int id = contactos.getSelectedIndex();
                    Contacto seleccionado = agenda.buscarContacto(id);
                    DatosContacto datosContacto = new DatosContacto();
                    ControlDatosContacto datos = new ControlDatosContacto(datosContacto, seleccionado);
                    datos.iniciar();
                    System.out.println("Se ha hecho 2 click");
                }
            }

        });
    }

    private boolean seleccionado() {
        if (!contactos.isSelectionEmpty()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un contacto");
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (VistaContactos.añadir == e.getSource()) {
            RegistroContacto datosContacto = new RegistroContacto();
            ControlRegistroContacto controlDatos = new ControlRegistroContacto(datosContacto, agenda, contacto);
            controlDatos.iniciar();
            vistaContactos.setVisible(false);
        }
        if (e.getActionCommand().equals("Actualizar") && seleccionado()) {
            int id = contactos.getSelectedIndex();
            Contacto seleccionado = agenda.buscarContacto(id);
            RegistroContacto actualizarContacto = new RegistroContacto();
            ControlRegistroContacto controlRegistro = new ControlRegistroContacto(actualizarContacto, agenda, seleccionado);
            controlRegistro.actualizarContacto();

        }
        if (e.getActionCommand().equals("Borrar") && seleccionado()) {
            int id = contactos.getSelectedIndex();
            Contacto seleccionado = agenda.buscarContacto(id);
            agenda.eliminarContacto(seleccionado);
            modelo.remove(id);
            if(agenda.getContactos().isEmpty()){
                VistaContactos.panel.removeAll();
            }

        }
    }

}

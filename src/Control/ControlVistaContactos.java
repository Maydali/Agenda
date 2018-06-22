/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Modelo.Contacto;
import Vista.DatosContacto;
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

    VistaContactos vistaContactos;
    ArrayList<Contacto> contactoArreglo= new ArrayList<>();;
    Contacto contacto;
    DefaultListModel modelo = new DefaultListModel();
    JList contactos = new JList();


    public ControlVistaContactos() {
    }
    

    public ControlVistaContactos(VistaContactos vistaContactos,Contacto contacto) {
        this.vistaContactos = vistaContactos;
        this.contacto = contacto;
        VistaContactos.añadir.addActionListener(this);
    }

    public void iniciar() {
        vistaContactos.setVisible(true);
       
    }

    public void contactosAnadidos() {
       contactoArreglo.add(contacto);
        
         for(int j=0; j<contactoArreglo.size(); j++){     
             System.out.println("nom " + contactoArreglo.get(j).getNombre());
              modelo.addElement(contactoArreglo.get(j).getNombre());
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
     
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (VistaContactos.añadir == e.getSource()) {
            DatosContacto datosContacto = new DatosContacto();
            ControlDatosContacto controlDatos = new ControlDatosContacto(datosContacto, contacto);
            controlDatos.iniciar();
            vistaContactos.setVisible(false);
        }
        if (e.getActionCommand().equals("Actualizar")) {
            JOptionPane.showMessageDialog(null, "Actualizar");
        }
        if (e.getActionCommand().equals("Borrar")) {
            JOptionPane.showMessageDialog(null, "Borrar");
        }
    }

    
    
    
}

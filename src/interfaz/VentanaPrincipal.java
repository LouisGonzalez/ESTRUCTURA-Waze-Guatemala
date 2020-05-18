/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ArbolB.Nodo;
import ArbolB.Raiz;
import OperacionesDistancia.CalculoRutas;
import OperacionesDistancia.ListaDestinos;
import entrada.ArchivoEntrada;
import java.awt.Image;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import pollitos.DatosCamino;

/**
 *
 * @author luisGonzalez
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private final ArchivoEntrada entrada = new ArchivoEntrada();
    private final ListaDestinos destinos = new ListaDestinos();
    private ArrayList<DatosCamino> listDatos;
    private final ArrayList<String> destinosPosibles = new ArrayList<>();
    private final CalculoRutas rutas = new CalculoRutas();
    private final Raiz arbolB = new Raiz();
    private int contId = 0;
    public static int idNodos = 1;
    public static int nodoGraph = 0;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        lblFondo.setIcon(new ImageIcon("/home/luisitopapurey/Escritorio/Estructura de datos/ProyectoFinal/image.jpeg"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboOrigen = new javax.swing.JComboBox<>();
        comboDestino = new javax.swing.JComboBox<>();
        btnRutas = new javax.swing.JButton();
        comboTransporte = new javax.swing.JComboBox<>();
        lblImagenFondo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        archivoEntrada = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrigenActionPerformed(evt);
            }
        });
        getContentPane().add(comboOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 190, -1));

        getContentPane().add(comboDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 212, -1));

        btnRutas.setText("Buscar Rutas");
        btnRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutasActionPerformed(evt);
            }
        });
        getContentPane().add(btnRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 210, -1));

        comboTransporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A pie", "Vehiculo" }));
        comboTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTransporteActionPerformed(evt);
            }
        });
        getContentPane().add(comboTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 130, -1));
        getContentPane().add(lblImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 790, 420));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 820, 550));

        jMenu1.setText("File");

        archivoEntrada.setText("Archivo de entrada");
        archivoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoEntradaActionPerformed(evt);
            }
        });
        jMenu1.add(archivoEntrada);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void archivoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoEntradaActionPerformed
        File archivoEntrada;
        String archivo;
        listDatos = new ArrayList<>();
        JFileChooser chooser = new JFileChooser();
        String seleccion = "Seleccione el archivo para crear el mapa";
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle(seleccion);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory: " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile: " + chooser.getSelectedFile());
            archivoEntrada = new File(chooser.getSelectedFile().getAbsolutePath());
            archivo = archivoEntrada.toString();
            if (archivo.endsWith(".txt")) {
                String[] texto = entrada.convertirTexto(archivoEntrada);
                entrada.repartirDatos(texto, listDatos, "imagen.jpg");
                destinos.agregarDestinos(destinosPosibles, listDatos);
                destinos.agregarAlListado(destinosPosibles, comboDestino);
                destinos.agregarAlListado(destinosPosibles, comboOrigen);
                ImageIcon imagen = new ImageIcon("/home/luisitopapurey/Escritorio/Estructura de datos/ProyectoFinal/imagen.jpg");
                Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(lblImagenFondo.getWidth(), lblImagenFondo.getHeight(), Image.SCALE_DEFAULT));
                JOptionPane.showMessageDialog(null, "insertar imagen");
                lblImagenFondo.setIcon(icon);
            } else {
                JOptionPane.showMessageDialog(null, "No es un archivo compatible");
            }
        }
    }//GEN-LAST:event_archivoEntradaActionPerformed

    private void comboOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrigenActionPerformed

    }//GEN-LAST:event_comboOrigenActionPerformed

    private void btnRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutasActionPerformed
        String tipoMovimiento = "";
        arbolB.eliminarNodos(arbolB.raiz);
        idNodos = 1;
        if (comboDestino.getItemCount() > 0) {
            if (comboDestino.getSelectedItem().equals(comboOrigen.getSelectedItem())) {
                JOptionPane.showMessageDialog(null, "No puedes dirigirte al mismo sitio");
            } else {
                if (comboTransporte.getSelectedItem().equals("A pie")) {
                    rutas.rutasAPie(comboOrigen.getSelectedItem().toString(), comboDestino.getSelectedItem().toString(), listDatos, true, arbolB);
                    tipoMovimiento = "A Pie";
                } else {
                    rutas.nuevaRuta(comboOrigen.getSelectedItem().toString(), comboDestino.getSelectedItem().toString(), listDatos, true, arbolB);
                    tipoMovimiento = "Vehiculo";
                }

                RutasPosibles posiblesRutas = new RutasPosibles(null, false, arbolB, tipoMovimiento, listDatos);

                posiblesRutas.setVisible(true);
            }
        }

    }//GEN-LAST:event_btnRutasActionPerformed

    private void comboTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTransporteActionPerformed

    }//GEN-LAST:event_comboTransporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem archivoEntrada;
    private javax.swing.JButton btnRutas;
    private javax.swing.JComboBox<String> comboDestino;
    private javax.swing.JComboBox<String> comboOrigen;
    private javax.swing.JComboBox<String> comboTransporte;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblImagenFondo;
    // End of variables declaration//GEN-END:variables
}

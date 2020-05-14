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
import OperacionesDistancia.MejoresRutas;
import entrada.ArchivoEntrada;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import pollitos.DatosCamino;
import pollitos.EstadisticasRutas;

/**
 *
 * @author luisGonzalez
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private final ArchivoEntrada entrada = new ArchivoEntrada();
    private final ListaDestinos destinos = new ListaDestinos();
    private ArrayList<DatosCamino> listDatos;
    private final ArrayList<String> destinosPosibles = new ArrayList<>();
    private final MejoresRutas mejores = new MejoresRutas();
    private final CalculoRutas rutas = new CalculoRutas();
    private final Raiz arbolB = new Raiz();
    private int contId = 0;
    public static int idNodos = 1;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboOrigen = new javax.swing.JComboBox<>();
        comboDestino = new javax.swing.JComboBox<>();
        btnRutas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        comboTransporte = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        archivoEntrada = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrigenActionPerformed(evt);
            }
        });

        btnRutas.setText("Buscar Rutas");
        btnRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutasActionPerformed(evt);
            }
        });

        jButton1.setText("Insertar nuevo nodo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        comboTransporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A pie", "Vehiculo" }));
        comboTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTransporteActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(comboTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(btnRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton3)
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)))
                .addComponent(comboTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRutas)
                .addGap(23, 23, 23))
        );

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
            } else {
                JOptionPane.showMessageDialog(null, "No es un archivo compatible");
            }
        }
    }//GEN-LAST:event_archivoEntradaActionPerformed

    private void comboOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrigenActionPerformed

    }//GEN-LAST:event_comboOrigenActionPerformed

    private void btnRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutasActionPerformed
        String tipoMovimiento = "";
        if (comboDestino.getSelectedItem().equals(comboOrigen.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "No puedes dirigirte al mismo sitio");
        } else {
            if(comboTransporte.getSelectedItem().equals("A pie")){
                rutas.rutasAPie(comboOrigen.getSelectedItem().toString(), comboDestino.getSelectedItem().toString(), listDatos, true, arbolB);
                tipoMovimiento = "A Pie";
            } else {
                rutas.nuevaRuta(comboOrigen.getSelectedItem().toString(), comboDestino.getSelectedItem().toString(), listDatos, true, arbolB);
                tipoMovimiento = "Vehiculo";
            }
        }
         RutasPosibles posiblesRutas = new RutasPosibles(null, false, arbolB, tipoMovimiento, listDatos);
      
         posiblesRutas.setVisible(true);
    }//GEN-LAST:event_btnRutasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        contId++;
        Nodo nuevo = new Nodo();
        nuevo.setId(contId);
        ArrayList<Integer> desgastePersona = new ArrayList<>();
        desgastePersona.add(45);
        nuevo.setDesgastePersona(desgastePersona);
        arbolB.insertar2(arbolB.raiz, nuevo, true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (int i = 0; i < arbolB.primerNodo.getMisRutas().length; i++) {
            if (arbolB.primerNodo.getMisRutas()[i] != null) {
                System.out.println(arbolB.primerNodo.getMisRutas()[i].getId() + "   ------");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.out.println("\n");
       arbolB.mostrarNodos(arbolB.raiz);
       //arbolB.metodo2(arbolB.raiz, true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.out.print("la raiz es :");
        for (int i = 0; i < arbolB.raiz.getMisRutas().length; i++) {
            if (arbolB.raiz.getMisRutas()[i] != null) {
               
                System.out.print(arbolB.raiz.getMisRutas()[i].getId() + " - " + i + " / ");
                if(i == 0){
                    if(arbolB.raiz.getMisRutas()[i].getHijoDerecho() != null){
                        System.out.println(arbolB.raiz.getMisRutas()[i].getHijoDerecho().getMisRutas()[0].getId()+  "           que teimportag");
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void comboTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTransporteActionPerformed
        
    }//GEN-LAST:event_comboTransporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem archivoEntrada;
    private javax.swing.JButton btnRutas;
    private javax.swing.JComboBox<String> comboDestino;
    private javax.swing.JComboBox<String> comboOrigen;
    private javax.swing.JComboBox<String> comboTransporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}

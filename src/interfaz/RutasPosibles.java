/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ArbolB.Nodo;
import ArbolB.NodoArbol;
import ArbolB.Raiz;
import Graphviz.CreacionSubGrafo;
import OperacionesDistancia.CalculoRutas;
import OperacionesDistancia.MejoresRutas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import pollitos.DatosCamino;

/**
 *
 * @author luisGonzalez
 */
public class RutasPosibles extends javax.swing.JDialog {

    private Raiz arbolB;
    private DefaultTableModel dtmModel;
    private CreacionSubGrafo grafo = new CreacionSubGrafo();
    private MejoresRutas mejores;
    private String tipoMovimiento;
    private final CalculoRutas rutas = new CalculoRutas();
    private ArrayList<DatosCamino> listDatos;

    /**
     * Creates new form RutasPosibles
     */
    public RutasPosibles(java.awt.Frame parent, boolean modal, Raiz arbolB, String tipoMovimiento, ArrayList<DatosCamino> listDatos) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.arbolB = arbolB;
        this.listDatos = listDatos;
        this.tipoMovimiento = tipoMovimiento;
        dtmModel = (DefaultTableModel) tablaRutas.getModel();
        Object[] fila = new Object[dtmModel.getColumnCount()];
        cargarTabla(dtmModel, fila, arbolB.raiz);
        mejores = new MejoresRutas();
        mejores.mostrarEstadisticas(arbolB);
        mejores.mejorRutaGasolina();
        mejores.mejorRutaAPie();
        mejores.mejorRutaDesgaste();
        mejores.mejorRutaDistancia();
        mejores.mejorRutaVehiculo();
        mejores.mejorRutaDesgasteDistancia();
        mejores.mejorRutaGasDistancia();
    }

    private void cargarTabla(DefaultTableModel dtmModel, Object[] fila, NodoArbol nodo) {
        for (int i = 0; i < nodo.getMisRutas().length; i++) {
            if (nodo.getMisRutas()[i] != null) {
                fila[0] = nodo.getMisRutas()[i].getId();
                dtmModel.addRow(fila);
                if (nodo.getMisRutas()[i].getHijoIzquierdo() != null) {
                    cargarTabla(dtmModel, fila, nodo.getMisRutas()[i].getHijoIzquierdo());
                }
                if (i == nodo.getMisRutas().length - 2 && nodo.getMisRutas()[i] != null) {
                    if (nodo.getMisRutas()[i].getHijoDerecho() != null) {
                        cargarTabla(dtmModel, fila, nodo.getMisRutas()[i].getHijoDerecho());
                    }
                }
                if (nodo.getMisRutas()[i + 1] == null && i < nodo.getMisRutas().length - 2) {
                    if (nodo.getMisRutas()[i].getHijoDerecho() != null) {
                        cargarTabla(dtmModel, fila, nodo.getMisRutas()[i].getHijoDerecho());
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRutas = new javax.swing.JTable();
        txt1 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        txtActual = new javax.swing.JTextField();
        txtSiguiente = new javax.swing.JTextField();
        txtFinal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtRGas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRDistancia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRFistancia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFisicoDistancia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGasDistancia = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTrayectorias = new javax.swing.JTextArea();
        btnSiguiente = new javax.swing.JButton();
        btnRutas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID"
            }
        ));
        tablaRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRutasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRutas);

        txt1.setText("Punto Actual:");

        txt2.setText("Punto siguiente:");

        txt3.setText("Destino final:");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel1.setText("Mejor ruta Gasolina:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel2.setText("Mejor ruta por distancia:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel3.setText("Mejor ruta desgaste fisico:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel4.setText("Mejor ruta desgaste fisico y distancia:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel5.setText("Mejor ruta gasolina y distancia:");

        txtTrayectorias.setColumns(20);
        txtTrayectorias.setRows(5);
        jScrollPane2.setViewportView(txtTrayectorias);

        btnSiguiente.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        btnSiguiente.setText("Pasar al siguiente punto");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnRutas.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        btnRutas.setText("Ver rutas en arbol");

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(txtSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFondoLayout.createSequentialGroup()
                            .addGap(300, 300, 300)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                            .addGap(358, 358, 358)
                            .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                .addComponent(btnRutas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(40, 40, 40)))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelFondoLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRGas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFisicoDistancia))
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRFistancia))
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGasDistancia)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt1)
                    .addComponent(txt2)
                    .addComponent(txt3))
                .addGap(6, 6, 6)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtRGas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtRDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFisicoDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtRFistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtGasDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(btnRutas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguiente))
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaRutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRutasMouseClicked
        int idNodo = (Integer) tablaRutas.getValueAt(tablaRutas.getSelectedRow(), 0);
        Nodo nodo = null;
        System.out.println(idNodo + "sdfdsf");
        nodo = arbolB.buscarNodos(arbolB.raiz, idNodo, nodo, false);

        if (nodo == null) {
            System.out.println("soy nulo F bro");
        }
        grafo.crearGrafo(nodo, lblImagen);
    }//GEN-LAST:event_tablaRutasMouseClicked

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        this.dispose();
        int idNodo = (Integer) tablaRutas.getValueAt(tablaRutas.getSelectedRow(), 0);
        Nodo nodo = null;
        nodo = arbolB.buscarNodos(arbolB.raiz, idNodo, nodo, false);
        
        nodo.getJerarquiaDestinos().remove(0);
        
        String nuevoOrigen = nodo.getJerarquiaDestinos().get(0);
        String destino = nodo.getJerarquiaDestinos().get(nodo.getJerarquiaDestinos().size() - 1);
        if (tipoMovimiento.equals("A Pie")) {
            rutas.rutasAPie(nuevoOrigen, destino, listDatos, true, arbolB);
        } else {
            rutas.nuevaRuta(nuevoOrigen, destino, listDatos, true, arbolB);
        }
        RutasPosibles posiblesRutas = new RutasPosibles(null, false, arbolB, tipoMovimiento, listDatos);

        posiblesRutas.setVisible(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRutas;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTable tablaRutas;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JTextField txtActual;
    private javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtFisicoDistancia;
    private javax.swing.JTextField txtGasDistancia;
    private javax.swing.JTextField txtRDistancia;
    private javax.swing.JTextField txtRFistancia;
    private javax.swing.JTextField txtRGas;
    private javax.swing.JTextField txtSiguiente;
    private javax.swing.JTextArea txtTrayectorias;
    // End of variables declaration//GEN-END:variables
}

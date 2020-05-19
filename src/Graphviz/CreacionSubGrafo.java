/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphviz;

import ArbolB.Nodo;
import entrada.ArchivoEntrada;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pollitos.DatosCamino;

/**
 *
 * @author luisGonzalez
 */
public class CreacionSubGrafo {

    private final Grafo creacion = new Grafo();
    private final ArchivoEntrada archivo = new ArchivoEntrada();

    public void crearGrafo(Nodo nodoTrabajar) {
        String texto = "";
        System.out.println(nodoTrabajar.getJerarquiaDestinos().size() + " xss ");
        for (int i = 0; i < nodoTrabajar.getJerarquiaDestinos().size(); i++) {
            if (i > 0) {
                texto += nodoTrabajar.getJerarquiaDestinos().get(i - 1) + "|" + nodoTrabajar.getJerarquiaDestinos().get(i) + "|";
                texto += nodoTrabajar.getTiemposVehiculo().get(i - 1) + "|";
                texto += nodoTrabajar.getTiemposAPie().get(i - 1) + "|";
                texto += nodoTrabajar.getGastosGas().get(i - 1) + "|";
                texto += nodoTrabajar.getDesgastePersona().get(i - 1) + "|";
                texto += nodoTrabajar.getDistancias().get(i - 1);
                texto += "\n";

            }

        }
        crearArchivoGrafo(texto);
        creacionDOT("imagen2.jpg");
        System.out.println(texto);
    }

    public void creacionDOT(String imagen) {
        ArrayList<DatosCamino> listDatos = new ArrayList<>();
        File archivoABuscar = new File("/home/luisitopapurey/Escritorio/Estructura de datos/ProyectoFinal/datosGrafica.txt");
        String texto[] = archivo.convertirTexto(archivoABuscar);
        archivo.repartirDatos(texto, listDatos, imagen);

    }

    public void crearArchivoGrafo(String texto) {
        File subGrafo = new File("datosGrafica.txt");
        if (subGrafo.exists()) {
            subGrafo.delete();
            crearArchivoGrafo(texto);
        } else {
            FileWriter writer = null;
            PrintWriter print = null;
            try {
                writer = new FileWriter(subGrafo);
                print = new PrintWriter(writer);
                print.print(texto);
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(CreacionSubGrafo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrada;

import Graphviz.Grafo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pollitos.DatosCamino;

/**
 *
 * @author luisGonzalez
 */
public class ArchivoEntrada {
    
    private Grafo grafo = new Grafo();
    
    public String[] convertirTexto(File archivo){
        BufferedReader buffer;
        String[] textoDevuelto = null;
        try {
            buffer = new BufferedReader(new FileReader(archivo));
            BufferedReader buffer2 = new BufferedReader(new FileReader(archivo));
            String linea = "";
            while(buffer2.readLine() != null){
                linea += buffer.readLine() + "\n";
            }
            textoDevuelto = linea.split("\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoEntrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return textoDevuelto;
    }
    
    public void repartirDatos(String[] datos, ArrayList<DatosCamino> listDatos, String imagen){
        String dibujoGrafo = "";
        for (int i = 0; i < datos.length; i++) {
            DatosCamino camino = new DatosCamino();
            String textoAux = datos[i];
            String[] datosNodo = textoAux.split("\\|");
            camino.setOrigen(datosNodo[0]);
            camino.setDestino(datosNodo[1]);
            camino.setTiempoVehiculo(Integer.parseInt(datosNodo[2]));
            camino.setTiempoAPie(Integer.parseInt(datosNodo[3]));
            camino.setGastoGas(Integer.parseInt(datosNodo[4]));
            camino.setDesgastePersona(Integer.parseInt(datosNodo[5]));
            camino.setDistancia(Integer.parseInt(datosNodo[6]));
            camino.setVisitado(false);
            dibujoGrafo += grafo.nuevaLinea(camino);
            listDatos.add(camino);
        }
        grafo.crearGrafo(dibujoGrafo);
        ProcessBuilder builder = new ProcessBuilder("dot","-Tjpg","-o", imagen, "grafica.dot");
        builder.redirectErrorStream(true);
        try {
            builder.start();
        } catch (IOException ex) {
            Logger.getLogger(ArchivoEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

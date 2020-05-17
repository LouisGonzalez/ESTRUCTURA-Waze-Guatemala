/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphviz;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pollitos.DatosCamino;

/**
 *
 * @author luisGonzalez
 */
public class Grafo {
        
    
    public String nuevaLinea(DatosCamino datos){
        String dibujado;
        dibujado = datos.getOrigen() + "->" + datos.getDestino() + "[label=\"a\"];\n";
        return dibujado;
    }
    
    public void crearGrafo(String texto){
        String inicio = "";
        inicio += "digraph G {\n";
        inicio += "rankdir=LR;\n";
        inicio += texto;
        inicio += "}";
        File grafica = new File("grafica.dot");
        if(grafica.exists()){
            grafica.delete();
            crearGrafo(texto);
        } else {
            FileWriter ficher = null;
            PrintWriter print = null;
            try {
                ficher = new FileWriter(grafica);
                print = new PrintWriter(ficher);
                print.print(inicio);
                ficher.close();
            } catch (IOException ex) {
                Logger.getLogger(Grafo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void crearArbolB(ArrayList<String> textos){
        String inicio = "";
        inicio += "digraph G {\n";
        inicio += "node [shape = record,height=.1]";
        for (int i = 0; i < textos.size(); i++) {
            inicio += textos.get(i);
        }
        inicio += "}";
        File grafica = new File("arbolB.dot");
        if(grafica.exists()){
            grafica.delete();
            crearArbolB(textos);
        } else {
            FileWriter ficher = null;
            PrintWriter print = null;
            try {
                ficher = new FileWriter(grafica);
                print = new PrintWriter(ficher);
                print.print(inicio);
                ficher.close();
            } catch (IOException ex) {
                Logger.getLogger(Grafo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

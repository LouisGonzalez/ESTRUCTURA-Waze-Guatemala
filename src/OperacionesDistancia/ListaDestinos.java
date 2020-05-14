/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesDistancia;

import java.util.ArrayList;
import javax.swing.JComboBox;
import pollitos.DatosCamino;

/**
 *
 * @author luisGonzalez
 */
public class ListaDestinos {
    
    
    public void agregarDestinos(ArrayList<String> listDestinos, ArrayList<DatosCamino> listDatos){
        for (int i = 0; i < listDatos.size(); i++) {
            verificarExistenciaDestino(listDestinos, listDatos.get(i).getOrigen());
            verificarExistenciaDestino(listDestinos, listDatos.get(i).getDestino());
        }
    }
    
    public void verificarExistenciaDestino(ArrayList<String> listDestinos, String destino){
        boolean siExiste = false;
        for (int i = 0; i < listDestinos.size(); i++) {
            if(destino.equals(listDestinos.get(i))){
                siExiste = true;
                break;
            }
        }
        if(!siExiste){
            listDestinos.add(destino);
        }
    }
    
    public void agregarAlListado(ArrayList<String> listDestinos, JComboBox listado){
        for (int i = 0; i < listDestinos.size(); i++) {
            listado.addItem(listDestinos.get(i));
        }
    }
    
}

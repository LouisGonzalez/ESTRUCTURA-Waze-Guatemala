/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesDistancia;

import ArbolB.Nodo;
import ArbolB.Raiz;
import interfaz.VentanaPrincipal;
import java.util.ArrayList;
import pollitos.DatosCamino;

/**
 *
 * @author luisGonzalez
 */
public class CalculoRutas {

    private ArrayList<String> jerarquiaDestinos;
    private ArrayList<Integer> tiemposVehiculo;
    private ArrayList<Integer> tiemposAPie;
    private ArrayList<Integer> gastosGas;
    private ArrayList<Integer> desgastePersona;
    private ArrayList<Integer> distancias;

    //METODO PARA CALCULAR LAS RUTAS POSIBLES DE UNA LOCACION A OTRA Y ASI AGREGARLAS AL ARBOL B    
    public void nuevaRuta(String origen, String destino, ArrayList<DatosCamino> listCaminos, boolean primero, Raiz arbolB) {
        for (int i = 0; i < listCaminos.size(); i++) {
            if (listCaminos.get(i).getOrigen().equals(origen) && !listCaminos.get(i).isVisitado() && !destino.equals(listCaminos.get(i).getOrigen())) {
                if (primero) {
                    inicializarArreglos();
                    jerarquiaDestinos.add(origen);
                }
                if (!verificarBucles2(jerarquiaDestinos, listCaminos.get(i).getOrigen(), origen) && !verificarBuclesDestinos(jerarquiaDestinos, listCaminos.get(i).getDestino())) {
                    listCaminos.get(i).setVisitado(true);
                    if (listCaminos.get(i).getDestino().equals(destino)) {
                        jerarquiaDestinos.add(listCaminos.get(i).getDestino());
                        agregarDatos(listCaminos, i);
                        escribirOrdenDestinos(jerarquiaDestinos);
                        escribirDatosNodo(tiemposVehiculo);
                        escribirDatosNodo(tiemposAPie);
                        escribirDatosNodo(gastosGas);
                        escribirDatosNodo(desgastePersona);
                        escribirDatosNodo(distancias);
                        agregarNodoArbol(arbolB);
                        removerUltimoDato();
                    } else {
                        jerarquiaDestinos.add(listCaminos.get(i).getDestino());
                        agregarDatos(listCaminos, i);
                        nuevaRuta(listCaminos.get(i).getDestino(), destino, listCaminos, false, arbolB);
                    }
                }
            }
        }
        buscarNodoAEliminar(origen, jerarquiaDestinos);
        borrarDatoEntero(tiemposVehiculo);
        borrarDatoEntero(tiemposAPie);
        borrarDatoEntero(gastosGas);
        borrarDatoEntero(desgastePersona);
        borrarDatoEntero(distancias);
        reiniciarVisitados(listCaminos, origen);
    }

    public void rutasAPie(String origen, String destino, ArrayList<DatosCamino> listCaminos, boolean primero, Raiz arbolB) {
        for (int i = 0; i < listCaminos.size(); i++) {
            if (!listCaminos.get(i).isVisitado()) {
                if (listCaminos.get(i).getOrigen().equals(origen)) {
                    if (primero) {
                        inicializarArreglos();
                        jerarquiaDestinos.add(origen);
                    }
                    if (!verificarBucles2(jerarquiaDestinos, listCaminos.get(i).getOrigen(), origen) && !verificarBuclesDestinos(jerarquiaDestinos, listCaminos.get(i).getDestino())) {
                        listCaminos.get(i).setVisitado(true);
                        if (listCaminos.get(i).getDestino().equals(destino)) {
                            jerarquiaDestinos.add(listCaminos.get(i).getDestino());
                            agregarDatos(listCaminos, i);
                            escribirOrdenDestinos(jerarquiaDestinos);
                            escribirDatosNodo(tiemposVehiculo);
                            escribirDatosNodo(tiemposAPie);
                            escribirDatosNodo(gastosGas);
                            escribirDatosNodo(desgastePersona);
                            escribirDatosNodo(distancias);
                            agregarNodoArbol(arbolB);
                            removerUltimoDato();
                        } else {
                            jerarquiaDestinos.add(listCaminos.get(i).getDestino());
                            agregarDatos(listCaminos, i);
                            rutasAPie(listCaminos.get(i).getDestino(), destino, listCaminos, false, arbolB);
                        }
                    }
                } else if (listCaminos.get(i).getDestino().equals(origen)) {
                    if (!listCaminos.get(i).isVisitado()) {
                        if (primero) {
                            inicializarArreglos();
                            jerarquiaDestinos.add(origen);
                        }
                        if (!verificarBucles(jerarquiaDestinos, listCaminos.get(i).getOrigen()) && !verificarBuclesDestinos(jerarquiaDestinos, listCaminos.get(i).getOrigen())) {
                            listCaminos.get(i).setVisitado(true);
                            if (listCaminos.get(i).getOrigen().equals(destino)) {
                                jerarquiaDestinos.add(listCaminos.get(i).getOrigen());
                                agregarDatos(listCaminos, i);
                                escribirOrdenDestinos(jerarquiaDestinos);
                                escribirDatosNodo(tiemposVehiculo);
                                escribirDatosNodo(tiemposAPie);
                                escribirDatosNodo(gastosGas);
                                escribirDatosNodo(desgastePersona);
                                escribirDatosNodo(distancias);
                                agregarNodoArbol(arbolB);
                                removerUltimoDato();
                                
                            } else {
                                jerarquiaDestinos.add(listCaminos.get(i).getOrigen());
                                agregarDatos(listCaminos, i);
                                rutasAPie(listCaminos.get(i).getOrigen(), destino, listCaminos, false, arbolB);
                            }
                        }
                    }
                }
            }
        }
        buscarNodoAEliminar(origen, jerarquiaDestinos);
        borrarDatoEntero(tiemposVehiculo);
        borrarDatoEntero(tiemposAPie);
        borrarDatoEntero(gastosGas);
        borrarDatoEntero(desgastePersona);
        borrarDatoEntero(distancias);
        reiniciarVisitados2(listCaminos, origen);
    }
    
    public void agregarNodoArbol(Raiz arbolB){
       Nodo nuevo = new Nodo();
       nuevo.setDesgastePersona(traspasarArregloEntero(desgastePersona));
       nuevo.setDistancias(traspasarArregloEntero(distancias));
       nuevo.setGastosGas(traspasarArregloEntero(gastosGas));
       nuevo.setJerarquiaDestinos(traspasarArregloString(jerarquiaDestinos));
       nuevo.setTiemposAPie(traspasarArregloEntero(tiemposAPie));
       nuevo.setTiemposVehiculo(traspasarArregloEntero(tiemposVehiculo));
       nuevo.setId(VentanaPrincipal.idNodos);
       arbolB.insertar2(arbolB.raiz, nuevo, true);
       VentanaPrincipal.idNodos++;
    }
    
    public ArrayList<Integer> traspasarArregloEntero(ArrayList<Integer> arreglo){
        ArrayList<Integer> auxiliar = new ArrayList<>();
        for (int i = 0; i < arreglo.size(); i++) {
            auxiliar.add(arreglo.get(i));
        }
        return auxiliar;
    }
    
    public ArrayList<String> traspasarArregloString(ArrayList<String> arreglo){
        ArrayList<String> auxiliar = new ArrayList<>();
        for (int i = 0; i < arreglo.size(); i++) {
            auxiliar.add(arreglo.get(i));
        }
        return auxiliar;
    }

    private void inicializarArreglos() {
        jerarquiaDestinos = new ArrayList<>();
        tiemposVehiculo = new ArrayList<>();
        tiemposAPie = new ArrayList<>();
        gastosGas = new ArrayList<>();
        desgastePersona = new ArrayList<>();
        distancias = new ArrayList<>();

    }

    private void removerUltimoDato() {
        jerarquiaDestinos.remove(jerarquiaDestinos.size() - 1);
        tiemposVehiculo.remove(tiemposVehiculo.size() - 1);
        tiemposAPie.remove(tiemposAPie.size() - 1);
        gastosGas.remove(gastosGas.size() - 1);
        desgastePersona.remove(desgastePersona.size() - 1);
        distancias.remove(distancias.size() - 1);

    }

    private void agregarDatos(ArrayList<DatosCamino> listCaminos, int i) {
        tiemposVehiculo.add(listCaminos.get(i).getTiempoVehiculo());
        tiemposAPie.add(listCaminos.get(i).getTiempoAPie());
        gastosGas.add(listCaminos.get(i).getGastoGas());
        desgastePersona.add(listCaminos.get(i).getDesgastePersona());
        distancias.add(listCaminos.get(i).getDistancia());

    }

    //metodo para diferenciar entre dos caminos que como trayectoria tienen la misma locacion
    public void buscarNodoAEliminar(String origen, ArrayList<String> listCaminos) {
        /*int contador = 0;
        for (int i = 0; i < listCaminos.size(); i++) {
            if (listCaminos.get(i).equals(origen)) {
                contador = i;
                break;
            }
        }
        if (!listCaminos.isEmpty()) {
            listCaminos.remove(contador);
        }*/
        if (!listCaminos.isEmpty()) {
            listCaminos.remove(listCaminos.size() - 1);
        }
    }

    public void borrarDatoEntero(ArrayList<Integer> lista) {
        if (!lista.isEmpty()) {
            lista.remove(lista.size() - 1);
        }
    }

    //METODO PARA REINICIAR EL INTERRUPTOR VISITADOS CUANDO SE CAMBIE A OTRA RUTA PARA QUE ASI PUEDAN SER USADAS LAS CARRETERAS
    public void reiniciarVisitados(ArrayList<DatosCamino> listCaminos, String origen) {
        for (int i = 0; i < listCaminos.size(); i++) {
            if (listCaminos.get(i).getOrigen().equals(origen)) {
                listCaminos.get(i).setVisitado(false);
            }
        }
    }

    public boolean verificarBucles(ArrayList<String> jerarquiaDestinos, String variable) {
        boolean bucle = false;
        for (int i = 0; i < jerarquiaDestinos.size(); i++) {
            if (variable.equals(jerarquiaDestinos.get(i))) {
                bucle = true;
                break;
            }
        }
        return bucle;
    }

    public boolean verificarBuclesDestinos(ArrayList<String> jerarquiaDestinos, String destino) {
        boolean bucle = false;
        for (int i = 0; i < jerarquiaDestinos.size(); i++) {
            if (jerarquiaDestinos.get(i).equals(destino)) {
                bucle = true;
                break;
            }
        }
        return bucle;
    }

    public boolean verificarBucles2(ArrayList<String> jerarquiaDestinos, String variable, String origen) {
        boolean bucle = false;
        if (!jerarquiaDestinos.isEmpty()) {
            if (!jerarquiaDestinos.get(jerarquiaDestinos.size() - 1).equals(origen)) {
                for (int i = 0; i < jerarquiaDestinos.size(); i++) {
                    if (variable.equals(jerarquiaDestinos.get(i))) {
                        bucle = true;
                        break;
                    }
                }
            }
        }
        return bucle;
    }

    public void reiniciarVisitados2(ArrayList<DatosCamino> listCaminos, String origen) {
        for (int i = 0; i < listCaminos.size(); i++) {
            if (listCaminos.get(i).getOrigen().equals(origen) || listCaminos.get(i).getDestino().equals(origen)) {
                listCaminos.get(i).setVisitado(false);
            }
        }
    }

    public void escribirOrdenDestinos(ArrayList<String> destinos) {
        for (int i = 0; i < destinos.size(); i++) {
            System.out.print(destinos.get(i) + " - ");
        }
        System.out.println("\n");
    }

    public void escribirDatosNodo(ArrayList<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i) + " - ");
        }
        System.out.println("\n");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesDistancia;

import ArbolB.Nodo;
import ArbolB.Raiz;
import java.util.ArrayList;
import javax.swing.JLabel;
import pollitos.EstadisticasRutas;

/**
 *
 * @author luisGonzalez
 */
public class MejoresRutas {

    private ArrayList<EstadisticasRutas> estadisticas;

    public void mostrarEstadisticas(Raiz arbolB) {
        estadisticas = new ArrayList<>();
        arbolB.calcularEstadisticas(arbolB.raiz, estadisticas);
        for (int i = 0; i < estadisticas.size(); i++) {
            System.out.println("ID: " + estadisticas.get(i).getId());
            System.out.println("Total tiempo vehiculo: " + estadisticas.get(i).getTotalHorasCarro());
            System.out.println("Total tiempo a pie: " + estadisticas.get(i).getTotalHorasPie());
            System.out.println("Total consumo gas: " + estadisticas.get(i).getTotalGasolina());
            System.out.println("Total desgaste personal: " + estadisticas.get(i).getTotalDesgaste());
            System.out.println("Total distancia: " + estadisticas.get(i).getTotalDistancia());
        }
        System.out.println("\n");
    }

    public Integer mejorRutaGasolina() {
        Integer idNodo = null;
        Integer nodoFor = null;
        if (estadisticas != null) {
            for (int i = 0; i < estadisticas.size(); i++) {
                if (i == 0) {
                    idNodo = estadisticas.get(i).getId();
                    nodoFor = i;
                } else {
                    if (estadisticas.get(nodoFor).getTotalGasolina() > estadisticas.get(i).getTotalGasolina()) {
                        idNodo = estadisticas.get(i).getId();
                        nodoFor = i;
                    }
                }
            }
            System.out.println("La ruta con menos gasto de gasolina es la no: " + idNodo);
        }
        return idNodo;
    }

    public Integer mejorRutaVehiculo() {
        Integer idNodo = null;
        Integer nodoFor = null;
        if (estadisticas != null) {
            for (int i = 0; i < estadisticas.size(); i++) {
                if (i == 0) {
                    idNodo = estadisticas.get(i).getId();
                    nodoFor = i;
                } else {
                    if (estadisticas.get(nodoFor).getTotalHorasCarro() > estadisticas.get(i).getTotalHorasCarro()) {
                        idNodo = estadisticas.get(i).getId();
                        nodoFor = i;
                    }
                }
            }
            System.out.println("La ruta con menos tiempo en vehiculo es la no: " + idNodo);
        }
        return idNodo;
    }

    public Integer mejorRutaAPie() {
        Integer idNodo = null;
        Integer nodoFor = null;
        if (estadisticas != null) {
            for (int i = 0; i < estadisticas.size(); i++) {
                if (i == 0) {
                    idNodo = estadisticas.get(i).getId();
                    nodoFor = i;
                } else {
                    if (estadisticas.get(nodoFor).getTotalHorasPie() > estadisticas.get(i).getTotalHorasPie()) {
                        idNodo = estadisticas.get(i).getId();
                        nodoFor = i;
                    }
                }
            }
            System.out.println("La ruta con menos tiempo a pie es la no: " + idNodo);
        }
        return idNodo;
    }

    public Integer mejorRutaDesgaste() {
        Integer idNodo = null;
        Integer nodoFor = null;
        if (estadisticas != null) {
            for (int i = 0; i < estadisticas.size(); i++) {
                if (i == 0) {
                    idNodo = estadisticas.get(i).getId();
                    nodoFor = i;
                } else {
                    if (estadisticas.get(nodoFor).getTotalDesgaste() > estadisticas.get(i).getTotalDesgaste()) {
                        idNodo = estadisticas.get(i).getId();
                        nodoFor = i;
                    }
                }
            }
            System.out.println("La ruta con menor desgaste personal es la no: " + idNodo);
        }
        return idNodo;
    }

    public Integer mejorRutaDistancia() {
        Integer idNodo = null;
        Integer nodoFor = null;
        if (estadisticas != null) {
            for (int i = 0; i < estadisticas.size(); i++) {
                if (i == 0) {
                    idNodo = estadisticas.get(i).getId();
                    nodoFor = i;
                } else {
                    if (estadisticas.get(nodoFor).getTotalDistancia() > estadisticas.get(i).getTotalDistancia()) {
                        idNodo = estadisticas.get(i).getId();
                        nodoFor = i;
                    }
                }

            }
            System.out.println("La ruta con menor distancia por recorrer es la no: " + idNodo);
        }
        return idNodo;
    }

    public Integer mejorRutaDesgasteDistancia() {
        Integer distancia = mejorRutaDistancia();
        Integer desgaste = mejorRutaDesgaste();
        Integer idGanador = null;
        if (distancia != null && desgaste != null) {
            int promedio1 = 0, promedio2 = 0;
            int id1 = 0, id2 = 0;
            if (distancia != desgaste) {
                for (int i = 0; i < estadisticas.size(); i++) {
                    if (estadisticas.get(i).getId() == distancia) {
                        promedio1 = (estadisticas.get(i).getTotalDesgaste() + estadisticas.get(i).getTotalDistancia()) / 2;
                        id1 = estadisticas.get(i).getId();
                    } else if (estadisticas.get(i).getId() == desgaste) {
                        promedio2 = (estadisticas.get(i).getTotalDesgaste() + estadisticas.get(i).getTotalDistancia()) / 2;
                        id2 = estadisticas.get(i).getId();
                    }
                }

                if (promedio1 > promedio2) {
                    idGanador = id2;
                } else {
                    idGanador = id1;
                }
            } else {
                for (int i = 0; i < estadisticas.size(); i++) {
                    if (estadisticas.get(i).getId() == distancia) {
                        idGanador = estadisticas.get(i).getId();
                        break;
                    }
                }
            }
            System.out.println("La mejor ruta relacion Desgaste/Distancia es la no: " + idGanador);
        }
        return idGanador;
    }

    public Integer mejorRutaGasDistancia() {
        Integer distancia = mejorRutaDistancia();
        Integer gas = mejorRutaGasolina();
        Integer idGanador = null;
        if (distancia != null && gas != null) {
            int promedio1 = 0, promedio2 = 0;
            int id1 = 0, id2 = 0;
            if (distancia != gas) {
                for (int i = 0; i < estadisticas.size(); i++) {
                    if (estadisticas.get(i).getId() == distancia) {
                        id1 = estadisticas.get(i).getId();
                    } else if (estadisticas.get(i).getId() == gas) {
                        id2 = estadisticas.get(i).getId();
                    }
                }
                if (promedio1 > promedio2) {
                    idGanador = id2;
                } else {
                    idGanador = id1;
                }
            } else {
                for (int i = 0; i < estadisticas.size(); i++) {
                    if (estadisticas.get(i).getId() == distancia) {
                        idGanador = estadisticas.get(i).getId();
                        break;
                    }
                }
            }
            System.out.println("La mejor ruta relacion Gas/Distancia es la no: " + idGanador);
        }
        return idGanador;

    }

    public String escribirTrayectoria(String texto, Nodo nodo) {
        for (int i = 0; i < nodo.getJerarquiaDestinos().size(); i++) {
            if (i == nodo.getJerarquiaDestinos().size() - 1) {
                texto += nodo.getJerarquiaDestinos().get(i);
            } else {
                texto += nodo.getJerarquiaDestinos().get(i) + " - ";
            }
        }
        texto += "\n";
        return texto;
    }

    public String escribirCostos(Nodo nodo, ArrayList<Integer> lista, String tipo) {
        String texto = "";
        Integer sumaTotal = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (i == lista.size() - 1) {
                texto += lista.get(i);
                sumaTotal = sumaTotal + lista.get(i);
            } else {
                texto += lista.get(i) + " - ";
                sumaTotal = sumaTotal + lista.get(i);
            }
        }
        if (tipo.equals("Distancia")) {
            texto += " \t\tDistancia total: " + sumaTotal + " km";
        } else if (tipo.equals("Gas")) {
            texto += " \t\tGasolina total: " + sumaTotal + " galones";
        } else if (tipo.equals("Desgaste")) {
            texto += " \t\tDesgaste fisico total: " + sumaTotal + " calorias.";
        } else if (tipo.equals("TiempoPie")) {
            texto += " \t\tTiempo a pie total: " + sumaTotal + " minutos.";
        } else if (tipo.equals("TiempoVehiculo")) {
            texto += " \t\tTiempo en vehiculo total: " + sumaTotal + " minutos.";
        }

        texto += "\n";

        return texto;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolB;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class Nodo {
    
    private int totalHorasCarro;
    private int totalHorasPie;
    private int totalGasolina;
    private int totalDesgaste;
    private int id;
    private ArrayList<String> jerarquiaDestinos;
    private ArrayList<Integer> tiemposVehiculo;
    private ArrayList<Integer> tiemposAPie;
    private ArrayList<Integer> gastosGas;
    private ArrayList<Integer> desgastePersona;
    private ArrayList<Integer> distancias;
    private NodoArbol hijoIzquierdo;
    private NodoArbol hijoDerecho;

    public int getTotalHorasCarro() {
        return totalHorasCarro;
    }

    public void setTotalHorasCarro(int totalHorasCarro) {
        this.totalHorasCarro = totalHorasCarro;
    }

    public int getTotalHorasPie() {
        return totalHorasPie;
    }

    public void setTotalHorasPie(int totalHorasPie) {
        this.totalHorasPie = totalHorasPie;
    }

    public int getTotalGasolina() {
        return totalGasolina;
    }

    public void setTotalGasolina(int totalGasolina) {
        this.totalGasolina = totalGasolina;
    }

    public int getTotalDesgaste() {
        return totalDesgaste;
    }

    public void setTotalDesgaste(int totalDesgaste) {
        this.totalDesgaste = totalDesgaste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getJerarquiaDestinos() {
        return jerarquiaDestinos;
    }

    public void setJerarquiaDestinos(ArrayList<String> jerarquiaDestinos) {
        this.jerarquiaDestinos = jerarquiaDestinos;
    }

    public ArrayList<Integer> getTiemposVehiculo() {
        return tiemposVehiculo;
    }

    public void setTiemposVehiculo(ArrayList<Integer> tiemposVehiculo) {
        this.tiemposVehiculo = tiemposVehiculo;
    }

    public ArrayList<Integer> getTiemposAPie() {
        return tiemposAPie;
    }

    public void setTiemposAPie(ArrayList<Integer> tiemposAPie) {
        this.tiemposAPie = tiemposAPie;
    }

    public ArrayList<Integer> getGastosGas() {
        return gastosGas;
    }

    public void setGastosGas(ArrayList<Integer> gastosGas) {
        this.gastosGas = gastosGas;
    }

    public ArrayList<Integer> getDesgastePersona() {
        return desgastePersona;
    }

    public void setDesgastePersona(ArrayList<Integer> desgastePersona) {
        this.desgastePersona = desgastePersona;
    }

    public ArrayList<Integer> getDistancias() {
        return distancias;
    }

    public void setDistancias(ArrayList<Integer> distancias) {
        this.distancias = distancias;
    }

    public NodoArbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoArbol getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoArbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    
    
    
    
}

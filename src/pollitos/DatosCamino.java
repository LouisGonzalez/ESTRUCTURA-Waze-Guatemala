/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollitos;

/**
 *
 * @author luisGonzalez
 */
public class DatosCamino {
    
    private String origen;
    private String destino;
    private int tiempoVehiculo;
    private int tiempoAPie;
    private int gastoGas;
    private int desgastePersona;
    private int distancia;
    private boolean visitado;

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTiempoVehiculo() {
        return tiempoVehiculo;
    }

    public void setTiempoVehiculo(int tiempoVehiculo) {
        this.tiempoVehiculo = tiempoVehiculo;
    }

    public int getTiempoAPie() {
        return tiempoAPie;
    }

    public void setTiempoAPie(int tiempoAPie) {
        this.tiempoAPie = tiempoAPie;
    }

    public int getGastoGas() {
        return gastoGas;
    }

    public void setGastoGas(int gastoGas) {
        this.gastoGas = gastoGas;
    }

    public int getDesgastePersona() {
        return desgastePersona;
    }

    public void setDesgastePersona(int desgastePersona) {
        this.desgastePersona = desgastePersona;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

 


    
}

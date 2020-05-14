/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolB;

/**
 *
 * @author luisGonzalez
 */
public class NodoArbol {
    
    private NodoArbol padre;
    private boolean tengoHijos;
    private Nodo[] misRutas;
    private final NodoArbol[] nodos;
    private boolean soyRaiz;
    
    public NodoArbol(){
        misRutas = new Nodo[5]; //5 rutas posibles por nodo (la ultima como auxiliar)
        nodos = new NodoArbol[6];  //5 posibles hijos
    }

    public boolean isSoyRaiz() {
        return soyRaiz;
    }

    public void setSoyRaiz(boolean soyRaiz) {
        this.soyRaiz = soyRaiz;
    }

    
    public boolean isTengoHijos() {
        return tengoHijos;
    }

    public void setTengoHijos(boolean tengoHijos) {
        this.tengoHijos = tengoHijos;
    }
    
    public NodoArbol getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }

    public Nodo[] getMisRutas() {
        return misRutas;
    }

    public NodoArbol[] getNodos() {
        return nodos;
    }
    
    
}

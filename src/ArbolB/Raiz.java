/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolB;

import interfaz.VentanaPrincipal;
import java.util.ArrayList;
import pollitos.EstadisticasRutas;

/**
 *
 * @author luisGonzalez
 */
public class Raiz {

    public NodoArbol primerNodo = new NodoArbol();
    public NodoArbol raiz;

    public Raiz() {
        primerNodo.setSoyRaiz(true);
        primerNodo.setPadre(null);
        raiz = primerNodo;
    }

    public void verificarIndividual(NodoArbol auxiliar) {
        if (auxiliar.getMisRutas()[4] != null) {
            NodoArbol izquierdo = new NodoArbol();
            NodoArbol derecho = new NodoArbol();
            for (int i = 0; i < 2; i++) {
                izquierdo.getMisRutas()[i] = auxiliar.getMisRutas()[i];
            }
            for (int i = 0; i < 2; i++) {
                derecho.getMisRutas()[i] = auxiliar.getMisRutas()[i + 3];
            }
            if (auxiliar.getPadre() != null) {
                if (auxiliar.getPadre().getMisRutas()[0] != null) {
                    System.out.println(auxiliar.getPadre().getMisRutas()[0].getHijoIzquierdo().getMisRutas()[0].getId() + " primer id de su hijo");
                }
            }
            subirNodo(auxiliar, izquierdo, derecho);
        }
    }

    public void agregarHijos(Nodo nuevo, Nodo auxiliar) {
        nuevo.setHijoDerecho(auxiliar.getHijoDerecho());
        for (int i = 0; i < nuevo.getHijoDerecho().getMisRutas().length; i++) {
            if (auxiliar.getHijoDerecho().getMisRutas()[i] != null) {
                agregarHijos(nuevo.getHijoDerecho().getMisRutas()[i], auxiliar.getHijoDerecho().getMisRutas()[i]);
            }
        }
        nuevo.setHijoIzquierdo(auxiliar.getHijoIzquierdo());
        for (int i = 0; i < nuevo.getHijoIzquierdo().getMisRutas().length; i++) {
            if (auxiliar.getHijoIzquierdo().getMisRutas()[i] != null) {
                agregarHijos(nuevo.getHijoIzquierdo().getMisRutas()[i], auxiliar.getHijoIzquierdo().getMisRutas()[i]);
            }
        }
    }

    public void subirNodo(NodoArbol elegido, NodoArbol izquierdo, NodoArbol derecho) {
        if (elegido == raiz) {
            nuevaRaiz(elegido, elegido.getMisRutas()[2], izquierdo, derecho);
        } else {
            insertarEspecifico(elegido.getPadre(), elegido.getMisRutas()[2], izquierdo, derecho);
            verificarIndividual(elegido.getPadre());
        }
    }

    public void nuevaRaiz(NodoArbol antiguaRaiz, Nodo nodoAInsertar, NodoArbol izquierdo, NodoArbol derecho) {
        NodoArbol nuevaRaiz = new NodoArbol();
        nuevaRaiz.setSoyRaiz(true);
        nuevaRaiz.setPadre(null);
        insertarEspecifico(nuevaRaiz, nodoAInsertar, izquierdo, derecho);
        if (izquierdo.getMisRutas()[0].getHijoIzquierdo() != null) {
            System.out.println(izquierdo.getMisRutas()[0].getHijoIzquierdo().getMisRutas()[0].getId() + "   sd");
        }
        if (derecho.getMisRutas()[0].getHijoIzquierdo() != null) {
            System.out.println(derecho.getMisRutas()[0].getHijoIzquierdo().getMisRutas()[0].getId() + "   sd");
        }
        raiz = nuevaRaiz;
        antiguaRaiz.setPadre(raiz);
        antiguaRaiz.setSoyRaiz(false);
    }

    public void insertarEspecifico(NodoArbol padre, Nodo nodoAInsertar, NodoArbol izquierdo, NodoArbol derecho) {
        for (int i = 0; i < padre.getMisRutas().length; i++) {
            if (padre.getMisRutas()[i] == null) {
                padre.getMisRutas()[i] = nodoAInsertar;
                derecho.setPadre(padre);
                izquierdo.setPadre(padre);
                if (i > 0) {
                    padre.getMisRutas()[i - 1].setHijoDerecho(izquierdo);
                }
                //FALTA VER SI HACER UN METODO RECURSIVO AQUI QUE ENGLOBE ESTA OPERACION
                for (int j = 0; j < derecho.getMisRutas().length; j++) {
                    if (derecho.getMisRutas()[j] != null) {
                        if (derecho.getMisRutas()[j].getHijoIzquierdo() != null) {
                            derecho.getMisRutas()[j].getHijoIzquierdo().setPadre(derecho);
                        }
                        if (derecho.getMisRutas()[j].getHijoDerecho() != null) {
                            derecho.getMisRutas()[j].getHijoDerecho().setPadre(derecho);
                        }
                    }
                }
                for (int j = 0; j < izquierdo.getMisRutas().length; j++) {
                    if (izquierdo.getMisRutas()[j] != null) {
                        if (izquierdo.getMisRutas()[j].getHijoIzquierdo() != null) {
                            izquierdo.getMisRutas()[j].getHijoIzquierdo().setPadre(izquierdo);
                        }
                        if (izquierdo.getMisRutas()[j].getHijoDerecho() != null) {
                            izquierdo.getMisRutas()[j].getHijoDerecho().setPadre(izquierdo);
                        }
                    }
                }
                //HASTA ACA EL POSIBLE METODO
                derecho.setSoyRaiz(false);
                izquierdo.setSoyRaiz(false);
                padre.getMisRutas()[i].setHijoIzquierdo(izquierdo);
                padre.getMisRutas()[i].setHijoDerecho(derecho);
                ordenar(padre);
                break;
            }
        }
    }

    public void insertar2(NodoArbol nodoArbol, Nodo nodoAInsertar, boolean a) {
        boolean hola = false;
        if (nodoArbol.getMisRutas()[0] == null) {
            nodoArbol.getMisRutas()[0] = nodoAInsertar;
        } else {
            for (int i = 0; i < nodoArbol.getMisRutas().length - 1; i++) {
                if (nodoArbol.getMisRutas()[i] != null) {
                    if (i == 3) {
                        if (nodoAInsertar.getId() > nodoArbol.getMisRutas()[i].getId()) {
                            if (nodoArbol.getMisRutas()[i].getHijoDerecho() != null) {
                                hola = true;
                                insertar2(nodoArbol.getMisRutas()[i].getHijoDerecho(), nodoAInsertar, false);
                            } else {
                                hola = true;
                                nodoArbol.getMisRutas()[i + 1] = nodoAInsertar;
                                ordenar(nodoArbol);
                                verificarIndividual(nodoArbol);
                            }
                        } else {
                            if (nodoArbol.getMisRutas()[i].getHijoIzquierdo() != null) {
                                hola = true;
                                insertar2(nodoArbol.getMisRutas()[i].getHijoIzquierdo(), nodoAInsertar, false);
                            } else {
                                for (int j = 0; j < nodoArbol.getMisRutas().length; j++) {
                                    if (nodoArbol.getMisRutas()[j] != null) {
                                        hola = true;
                                        nodoArbol.getMisRutas()[j] = nodoAInsertar;
                                        ordenar(nodoArbol);
                                        verificarIndividual(nodoArbol);
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        if (nodoAInsertar.getId() <= nodoArbol.getMisRutas()[i].getId()) {
                            if (nodoArbol.getMisRutas()[i].getHijoIzquierdo() != null) {
                                hola = true;
                                insertar2(nodoArbol.getMisRutas()[i].getHijoIzquierdo(), nodoAInsertar, false);
                            } else {
                                for (int j = 0; j < nodoArbol.getMisRutas().length; j++) {
                                    if (nodoArbol.getMisRutas()[j] != null) {
                                        hola = true;
                                        nodoArbol.getMisRutas()[j] = nodoAInsertar;
                                        ordenar(nodoArbol);
                                        verificarIndividual(nodoArbol);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (i > 0) {
                        if (nodoArbol.getMisRutas()[i - 1].getHijoDerecho() != null) {
                            hola = true;
                            insertar2(nodoArbol.getMisRutas()[i - 1].getHijoDerecho(), nodoAInsertar, false);
                        } else {
                            hola = true;
                            nodoArbol.getMisRutas()[i] = nodoAInsertar;
                            System.out.println(nodoArbol.getMisRutas()[0].getDesgastePersona().get(0) + " VALORMODERFUCKER");
                            ordenar(nodoArbol);
                            verificarIndividual(nodoArbol);
                        }
                    } else {
                        hola = true;
                        nodoArbol.getMisRutas()[i] = nodoAInsertar;
                        ordenar(nodoArbol);
                        verificarIndividual(nodoArbol);
                    }
                }
                if (hola == true) {
                    break;
                }
            }
        }
    }

    public void ordenar(NodoArbol nodoAux) {
        int x = 0;
        for (int i = 0; i < nodoAux.getMisRutas().length; i++) {
            if (nodoAux.getMisRutas()[i] == null) {
                break;
            } else {
                x++;
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x - 1; j++) {
                if (nodoAux.getMisRutas()[j].getId() > nodoAux.getMisRutas()[j + 1].getId()) {
                    Nodo aux = nodoAux.getMisRutas()[j];
                    nodoAux.getMisRutas()[j] = nodoAux.getMisRutas()[j + 1];
                    nodoAux.getMisRutas()[j + 1] = aux;
                }
            }
        }

    }

    public void metodo2(NodoArbol nodo, boolean a) {
        for (int i = 0; i < nodo.getMisRutas().length; i++) {
            if (nodo.getMisRutas()[i] != null) {
                System.out.print(nodo.getMisRutas()[i].getId() + " - ");
            }
        }
        System.out.println("\n");
        for (int i = 0; i < nodo.getNodos().length; i++) {
            if (nodo.getNodos()[i] != null) {
                metodo2(nodo.getNodos()[i], false);
            }
        }
    }

    public void mostrarNodos(NodoArbol raiz) {
        for (int i = 0; i < raiz.getMisRutas().length; i++) {
            if (raiz.getMisRutas()[i] != null) {
                System.out.print(raiz.getMisRutas()[i].getId() + " -sa ");
                if (raiz.getMisRutas()[i].getHijoIzquierdo() != null) {
                    System.out.println("\n");
                    mostrarNodos(raiz.getMisRutas()[i].getHijoIzquierdo());
                }
                if (i == raiz.getMisRutas().length - 2 && raiz.getMisRutas()[i] != null) {
                    if (raiz.getMisRutas()[i].getHijoDerecho() != null) {
                        System.out.println("\n");
                        mostrarNodos(raiz.getMisRutas()[i].getHijoDerecho());
                    }
                }
                if (raiz.getMisRutas()[i + 1] == null && i < raiz.getMisRutas().length - 2) {
                    if (raiz.getMisRutas()[i].getHijoDerecho() != null) {
                        System.out.println("\n");
                        mostrarNodos(raiz.getMisRutas()[i].getHijoDerecho());
                    }
                }
            }
        }
    }

    private String escribirTrayectoriasArbol(ArrayList<String> trayectorias) {
        String texto = "";
        for (int i = 0; i < trayectorias.size(); i++) {
            texto += trayectorias.get(i) + " - ";
        }
        return texto;
    }

    public void crearGraphviz(NodoArbol nodoArbol, ArrayList<String> nodos, boolean primero, Integer aux2, Integer padre2, String lado) {
        if (primero) {
            VentanaPrincipal.nodoGraph = 0;
        }
        String texto = "node" + VentanaPrincipal.nodoGraph + "[label = \"";
        int padre = VentanaPrincipal.nodoGraph;
        VentanaPrincipal.nodoGraph++;
        for (int i = 0; i < nodoArbol.getMisRutas().length - 1; i++) {
            if (i < nodoArbol.getMisRutas().length - 2) {
                if (nodoArbol.getMisRutas()[i] != null) {
                    texto += "<f" + i + ">" + "| " + escribirTrayectoriasArbol(nodoArbol.getMisRutas()[i].getJerarquiaDestinos()) /*nodoArbol.getMisRutas()[i].getId()*/ + " |";
                } else {
                    texto += "<f" + i + ">" + "|  |";

                }
            } else {
                if (nodoArbol.getMisRutas()[i] != null) {
                    int contFinal = i + 1;
                    texto += "<f" + i + ">" + "| " + escribirTrayectoriasArbol(nodoArbol.getMisRutas()[i].getJerarquiaDestinos()) /*nodoArbol.getMisRutas()[i].getId()*/ + " | <f" + contFinal + "> \"];\n";

                } else {
                    int contFinal = i + 1;
                    texto += "<f" + i + ">" + "|  | <f" + contFinal + "> \"];\n";
                }
            }
        }
        nodos.add(texto);
        if (aux2 != null) {
            if (nodoArbol.getPadre() != null) {
                int a = VentanaPrincipal.nodoGraph - 1;
                String aux = "";
                if (lado == null || lado.equals("Izquierda")) {
                    aux = "\"node" + padre2 + "\": f" + aux2 + " -> \"node" + a + "\"\n";
                } else if(lado.equals("Derecha")){
                    int aux3 = aux2 + 1;
                    aux = "\"node" + padre2 + "\": f" + aux3 + " -> \"node" + a + "\"\n";
                    
                }
                nodos.add(aux);
            }
        }
        for (int i = 0; i < nodoArbol.getMisRutas().length - 1; i++) {
            if (nodoArbol.getMisRutas()[i] != null) {
                if (nodoArbol.getMisRutas()[i].getHijoIzquierdo() != null) {
                    crearGraphviz(nodoArbol.getMisRutas()[i].getHijoIzquierdo(), nodos, false, i, padre, "Izquierda");
                }
                if (i == nodoArbol.getMisRutas().length - 2 && nodoArbol.getMisRutas()[i] != null) {
                    if (nodoArbol.getMisRutas()[i].getHijoDerecho() != null) {
                        crearGraphviz(nodoArbol.getMisRutas()[i].getHijoDerecho(), nodos, false, i, padre, "Derecha");
                    }
                }
                if (nodoArbol.getMisRutas()[i + 1] == null && i < raiz.getMisRutas().length - 2) {
                    if (nodoArbol.getMisRutas()[i].getHijoDerecho() != null) {
                        crearGraphviz(nodoArbol.getMisRutas()[i].getHijoDerecho(), nodos, false, i, padre, "Derecha");
                    }
                }
            }
        }
    }

    public Nodo buscarNodos(NodoArbol raiz, int id, Nodo nodoBuscado, boolean encontrado) {
        if (encontrado == false) {
            for (int i = 0; i < raiz.getMisRutas().length; i++) {
                if (raiz.getMisRutas()[i] != null) {
                    if (raiz.getMisRutas()[i].getId() == id) {
                        nodoBuscado = raiz.getMisRutas()[i];
                        encontrado = true;
                    }
                    if (raiz.getMisRutas()[i].getHijoIzquierdo() != null) {
                        System.out.println("\n");
                        nodoBuscado = buscarNodos(raiz.getMisRutas()[i].getHijoIzquierdo(), id, nodoBuscado, encontrado);
                    }
                    if (i == raiz.getMisRutas().length - 2 && raiz.getMisRutas()[i] != null) {
                        if (raiz.getMisRutas()[i].getHijoDerecho() != null) {
                            System.out.println("\n");
                            nodoBuscado = buscarNodos(raiz.getMisRutas()[i].getHijoDerecho(), id, nodoBuscado, encontrado);
                        }
                    }
                    if (raiz.getMisRutas()[i + 1] == null && i < raiz.getMisRutas().length - 2) {
                        if (raiz.getMisRutas()[i].getHijoDerecho() != null) {
                            System.out.println("\n");
                            nodoBuscado = buscarNodos(raiz.getMisRutas()[i].getHijoDerecho(), id, nodoBuscado, encontrado);
                        }
                    }
                }
            }
        }
        return nodoBuscado;
    }

    public ArrayList<EstadisticasRutas> calcularEstadisticas(NodoArbol nodo, ArrayList<EstadisticasRutas> listEstadisticas) {
        for (int i = 0; i < nodo.getMisRutas().length; i++) {
            if (nodo.getMisRutas()[i] != null) {
                //aqui se calculan todas las rutas
                EstadisticasRutas stats = new EstadisticasRutas();
                stats.setId(nodo.getMisRutas()[i].getId());
                stats.setTotalDesgaste(totalElemento(nodo.getMisRutas()[i].getDesgastePersona()));
                stats.setTotalDistancia(totalElemento(nodo.getMisRutas()[i].getDistancias()));
                stats.setTotalGasolina(totalElemento(nodo.getMisRutas()[i].getGastosGas()));
                stats.setTotalHorasCarro(totalElemento(nodo.getMisRutas()[i].getTiemposVehiculo()));
                stats.setTotalHorasPie(totalElemento(nodo.getMisRutas()[i].getTiemposAPie()));
                listEstadisticas.add(stats);
                if (nodo.getMisRutas()[i].getHijoIzquierdo() != null) {
                    System.out.println("\n");
                    calcularEstadisticas(nodo.getMisRutas()[i].getHijoIzquierdo(), listEstadisticas);
                }
                if (i == nodo.getMisRutas().length - 2 && nodo.getMisRutas()[i] != null) {
                    if (nodo.getMisRutas()[i].getHijoDerecho() != null) {
                        System.out.println("\n");
                        calcularEstadisticas(nodo.getMisRutas()[i].getHijoDerecho(), listEstadisticas);
                    }
                }
                if (nodo.getMisRutas()[i + 1] == null && i < nodo.getMisRutas().length - 2) {
                    if (nodo.getMisRutas()[i].getHijoDerecho() != null) {
                        System.out.println("\n");
                        calcularEstadisticas(nodo.getMisRutas()[i].getHijoDerecho(), listEstadisticas);
                    }
                }
            }
        }

        return listEstadisticas;
    }

    public void eliminarNodos(NodoArbol nodoArbol) {
        if (nodoArbol != null) {
            for (int i = 0; i < nodoArbol.getMisRutas().length - 1; i++) {
                if (i > 0) {
                    if (nodoArbol.getMisRutas()[i] == null) {
                        if (nodoArbol.getMisRutas()[i - 1].getHijoDerecho() != null) {
                            if (nodoArbol.getMisRutas()[i - 1].getHijoDerecho().getMisRutas()[0] != null) {
                                eliminarNodos(nodoArbol.getMisRutas()[i - 1].getHijoDerecho());
                            } else {
                                nodoArbol.getMisRutas()[i - 1].setHijoDerecho(null);
                                eliminarNodos(nodoArbol);
                            }
                        } else {
                            nodoArbol.getMisRutas()[i - 1] = null;
                            eliminarNodos(nodoArbol);
                        }
                    }
                    break;
                } else {
                    if (nodoArbol.getMisRutas()[i] != null) {
                        if (nodoArbol.getMisRutas()[i].getHijoDerecho() != null) {
                            if (nodoArbol.getMisRutas()[i].getHijoDerecho().getMisRutas()[0] != null) {
                                eliminarNodos(nodoArbol.getMisRutas()[i].getHijoDerecho());
                            } else {
                                nodoArbol.getMisRutas()[i].setHijoDerecho(null);
                                eliminarNodos(nodoArbol);
                            }
                        } else {
                            nodoArbol.getMisRutas()[i] = null;
                            eliminarNodos(nodoArbol.getPadre());
                        }
                    }
                    break;
                }
            }
        }
    }

    private int totalElemento(ArrayList<Integer> listDatos) {
        int total = 0;
        for (int i = 0; i < listDatos.size(); i++) {
            total = total + listDatos.get(i);
        }
        return total;
    }

}

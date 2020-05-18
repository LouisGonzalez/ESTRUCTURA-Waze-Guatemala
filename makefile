JCC = javac

JFLAGS = -g

default: ListadoDatos.class NodoArbol.class Nodo.class Raiz.class ArchivoEntrada.class CreacionSubGrafo.class Grafo.class RutaEspecifica.class
	RutasPosibles.class CalculoRutas.class ListadoDestinos.class MejoresRutas.class DatosCamino.class EstadisticasRutas.class  			VentanaPrincipal.class ProyectoFinal.class

ProyectoFinal.class: src/proyectoFinal/ProyectoFinal.java
	$(JCC) $(JFLAGS) src/proyectoFinal/ProyectoFinal.java

ListadoDatos.class: src/ArbolB/ListadoDatos.java
	$(JCC) $(JFLAGS) src/ArbolB/ListadoDatos.java

NodoArbol.class: src/ArbolB/NodoArbol.java
	$(JCC) $(JFLAGS) src/ArbolB/NodoArbol.java

Nodo.class: src/ArbolB/Nodo.java
	$(JCC) $(JFLAGS) src/ArbolB/Nodo.java

Raiz.class: src/ArbolB/Raiz.java
	$(JCC) $(JFLAGS) src/ArbolB/Raiz.java

ArchivoEntrada.class: src/entrada/ArchivoEntrada.java
	$(JCC) $(JFLAGS) src/ArbolB/ArchivoEntrada.java

CreacionSubGrafo.class: src/Graphviz/CreacionSubGrafo.java
	$(JCC) $(JFLAGS) src/Graphviz/CreacionSubGrafo.java

Grafo.class: src/Graphviz/Grafo.java
	$(JCC) $(JFLAGS) src/Graphviz/Grafo.java

RutaEspecifica.class: src/interfaz/RutaEspecifica.java
	$(JCC) $(JFLAGS) src/interfaz/RutaEspecifica.java

RutasPosibles.class: src/interfaz/RutasPosibles.java
	$(JCC) $(JFLAGS) src/interfaz/RutasPosibles.java

CalculoRutas.class: src/OperacionesDistancia/CalculoRutas.java
	$(JCC) $(JFLAGS) src/OperacionesDistancia/CalculoRutas.java

ListaDestinos.class: src/OperacionesDistancia/ListaDestinos.java
	$(JCC) $(JFLAGS) src/OperacionesDistancia/ListadoDestinos.java

MejoresRutas.class: src/OperacionesDistancia/MejoresRutas.java
	$(JCC) $(JFLAGS) src/OperacionesDistancia/MejoresRutas.java

DatosCamino.class: src/pollitos/DatosCamino.java
	$(JCC) $(JFLAGS) src/pollitos/DatosCamino.java

EstadisticasRutas.class: src/pollitos/EstadisticasRutas.java
	$(JCC) $(JFLAGS) src/pollitos/EstadisticasRutas.java

VentanaPrincipal.class: src/interfaz/VentanaPrincipal.java
	$(JCC) $(JFLAGS) src/interfaz/VentanaPrincipal.java


clean:
	$(RM) src/proyectofinal/*.class
	$(RM) src/ArbolB/*.class
	$(RM) src/entrada/*.class
	$(RM) src/Graphviz/*.class
	$(RM) src/interfaz/*.class
	$(RM) src/OperacionesDistancia/*.class
	$(RM) src/pollitos/*.class

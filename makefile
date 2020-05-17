JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        src/proyectofinal/ProyectoFinal.java
	src/ArbolB/*.java
	src/entrada/*.java
	src/Graphviz/*.java
	src/interfaz/*.java
	src/OperacionesDistancia/*.java
	src/pollitos/*.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) src/proyectofinal/*.class
	$(RM) src/ArbolB/*.class
	$(RM) src/entrada/*.class
	$(RM) src/Graphviz/*.class
	$(RM) src/interfaz/*.class
	$(RM) src/OperacionesDistancia/*.class
	$(RM) src/pollitos/*.class

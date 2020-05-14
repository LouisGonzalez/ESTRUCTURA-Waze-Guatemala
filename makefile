JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        src/proyectofinal/ProyectoFinal.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) src/proyectofinal/*.class 		

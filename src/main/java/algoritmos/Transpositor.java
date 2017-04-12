package algoritmos;

import entidades.Grafo;
import entidades.Vertice;

public class Transpositor {

    private Grafo grafo;

    public Transpositor() {

    }

    public Transpositor(Grafo grafo) {
        this.grafo = grafo;
    }

    public Grafo transporGrafo() {
        grafo.getVertices().forEach(vertice -> {
            vertice.getArestas().forEach(aresta -> {
                Vertice auxiliar = aresta.getVerticesChegada();
                aresta.setVerticesChegada(aresta.getVerticesPartida());
                aresta.setVerticesPartida(auxiliar);
            });
        });
        return grafo;
    }

}

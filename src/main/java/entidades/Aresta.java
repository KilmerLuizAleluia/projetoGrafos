package entidades;

public class Aresta {
    private Vertice verticesPartida;
    private Vertice verticesChegada;

    public Aresta() {

    }

    public Aresta(Vertice verticesPartida, Vertice verticesChegada) {
        this.verticesPartida = verticesPartida;
        this.verticesChegada = verticesChegada;
    }

    public Vertice getVerticesPartida() {
        return verticesPartida;
    }

    public void setVerticesPartida(Vertice verticesPartida) {
        this.verticesPartida = verticesPartida;
    }

    public Vertice getVerticesChegada() {
        return verticesChegada;
    }

    public void setVerticesChegada(Vertice verticesChegada) {
        this.verticesChegada = verticesChegada;
    }

    public Vertice getVizinho(Vertice vertice) {
        return null;
    }
}

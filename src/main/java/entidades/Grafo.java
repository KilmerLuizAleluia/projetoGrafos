package entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grafo {

    private List<Vertice> vertices = new ArrayList<Vertice>();

    public Grafo () {

    }

    public Grafo (Vertice... vertice) {
        adicionarVertice(vertice);
    }

    public List<Vertice> getVertices() {
        return vertices;
    }


    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }

    public void adicionarVertice(Vertice... vertice) {
        vertices.addAll(Arrays.asList(vertice));
    }

}

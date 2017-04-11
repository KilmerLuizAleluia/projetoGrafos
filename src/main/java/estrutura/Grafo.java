package estrutura;

import enums.Cor;

import java.util.*;

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

    public void dfsGrafo() {
        Vertice vertice;
        while ((vertice = procurarVerticesNaoPercorridos()) != null) {
            Vertice.incrementarMomento();
            vertice.dfs();
        }
        vertices.sort(Comparator.comparing(Vertice::getMomentoFinalizacao));
    }

    private Vertice procurarVerticesNaoPercorridos() {
        for (Vertice vertice : vertices) {
            if (vertice.getCor().equals(Cor.BRANCO)) {
                return vertice;
            }
        }
        return null;
    }
}

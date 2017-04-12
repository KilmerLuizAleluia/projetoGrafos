package algoritmos;

import entidades.Aresta;
import entidades.Grafo;
import entidades.Vertice;
import enums.Cor;

import java.util.Comparator;

public class DFS {

    public DFS() {

    }

    public DFS(Grafo grafo) {
        dfsGrafo(grafo);
        Vertice.inicializarMomento();
    }

    private void dfsGrafo(Grafo grafo) {
        Vertice vertice;
        while ((vertice = procurarVerticesNaoPercorridos(grafo)) != null) {
            Vertice.incrementarMomento();
            dfsVertice(vertice);
        }
//        TODO - Passo 3 (tambem falta passo 2 - transpor grafo):
//        grafo.getVertices().sort(Comparator.comparing(Vertice::getMomentoFinalizacao));
    }

    private Vertice procurarVerticesNaoPercorridos(Grafo grafo) {
        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getCor().equals(Cor.BRANCO)) {
                return vertice;
            }
        }
        return null;
    }

    private void dfsVertice(Vertice vertice) {

        if (vertice.hasArestasSaindo()) {
            vertice.setMomentoDescoberta(Vertice.getMOMENTO());
            vertice.setCor(Cor.CINZA);
            System.out.println("Momento: " + Vertice.getMOMENTO() + "; entidades.Vertice " + vertice.getNome() + ": CINZA");

            for (Aresta aresta : vertice.getArestasSaindo()) {
                if (verticeJaPercorrido(aresta)) {
                    break;
                }
                Vertice.incrementarMomento();
                aresta.getVerticesChegada().setPai(vertice);
                dfsVertice(aresta.getVerticesChegada());
            }

        }
        Vertice.incrementarMomento();
        System.out.println("Momento: " + Vertice.getMOMENTO() + "; entidades.Vertice " + vertice.getNome() + ": PRETO");
        vertice.setMomentoFinalizacao(Vertice.getMOMENTO());
        vertice.setCor(Cor.PRETO);

    }

    private boolean verticeJaPercorrido(Aresta aresta) {
        return !aresta.getVerticesChegada().getCor().equals(Cor.BRANCO);
    }


}

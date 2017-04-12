package main;

import algoritmos.DFS;
import algoritmos.Transpositor;
import entidades.Aresta;
import entidades.Grafo;
import entidades.Vertice;

public class Main {
    public static void main(String[] args) {
        teste1();
        teste2();
//        testeSlide();
    }

    private static void teste1() {
        Vertice vertice1 = new Vertice("v1");
        Vertice vertice2 = new Vertice("v2");
        Vertice vertice3 = new Vertice("v3");

        Aresta aresta12 = new Aresta(vertice1, vertice2);
        Aresta aresta23 = new Aresta(vertice2, vertice3);
        Aresta aresta31 = new Aresta(vertice3, vertice1);

        vertice1.addArestas(aresta12, aresta31);
        vertice2.addArestas(aresta23, aresta12);
        vertice3.addArestas(aresta31, aresta23);

        Grafo grafo = new Grafo(vertice1, vertice2, vertice3);
        new DFS(grafo);
        Transpositor transpositor = new Transpositor(grafo);
        Grafo grafoTransposto = transpositor.transporGrafo();
    }

    private static void teste2() {
        Vertice vertice1 = new Vertice("v1");
        Vertice vertice2 = new Vertice("v2");
        Vertice vertice3 = new Vertice("v3");
        Vertice vertice4 = new Vertice("v4");
        Vertice vertice5 = new Vertice("v5");

        Aresta aresta12 = new Aresta(vertice1, vertice2);
        Aresta aresta13 = new Aresta(vertice1, vertice3);
        Aresta aresta23 = new Aresta(vertice2, vertice3);
        Aresta aresta34 = new Aresta(vertice3, vertice4);
        Aresta aresta35 = new Aresta(vertice3, vertice5);
        Aresta aresta45 = new Aresta(vertice4, vertice5);
        Aresta aresta54 = new Aresta(vertice5, vertice4);

        vertice1.addArestas(aresta12, aresta13);
        vertice2.addArestas(aresta23, aresta12);
        vertice3.addArestas(aresta34, aresta35, aresta13, aresta23);
        vertice4.addArestas(aresta45, aresta34, aresta54);
        vertice5.addArestas(aresta54, aresta35, aresta45);

        Grafo grafo = new Grafo(vertice1, vertice2, vertice3, vertice4, vertice5);
        new DFS(grafo);
        Transpositor transpositor = new Transpositor(grafo);
        Grafo grafoTransposto = transpositor.transporGrafo();
    }

    private static void testeSlide() {
        Vertice s = new Vertice("s");
        Vertice z = new Vertice("z");
        Vertice y = new Vertice("y");
        Vertice x = new Vertice("x");
        Vertice w = new Vertice("w");
        Vertice v = new Vertice("v");
        Vertice u = new Vertice("u");
        Vertice t = new Vertice("t");

        Aresta arestasz = new Aresta(s, z);
        Aresta arestasw = new Aresta(s, w);
        Aresta arestazw = new Aresta(z, w);
        Aresta arestazy = new Aresta(z, y);
        Aresta arestayx = new Aresta(y, x);
        Aresta arestaxz = new Aresta(x, z);
        Aresta arestawx = new Aresta(w, x);
        Aresta arestavw = new Aresta(v, w);
        Aresta arestavs = new Aresta(v, s);
        Aresta arestatv = new Aresta(t, v);
        Aresta arestatu = new Aresta(t, u);
        Aresta arestauv = new Aresta(u, v);
        Aresta arestaut = new Aresta(u, t);

        s.addArestas(arestasz, arestasw, arestavs);
        z.addArestas(arestazy, arestazw, arestasz, arestaxz);
        y.addArestas(arestayx, arestazy);
        x.addArestas(arestaxz, arestayx, arestawx);
        w.addArestas(arestawx, arestazw, arestasw, arestavw);
        t.addArestas(arestatv, arestatu, arestaut);
        v.addArestas(arestavw, arestavs, arestatv, arestatu);
        u.addArestas(arestauv, arestaut, arestatu);

        Grafo grafo = new Grafo(s, z, y, x, w, t, v, u);
        new DFS(grafo);
        Transpositor transpositor = new Transpositor(grafo);
        Grafo grafoTransposto = transpositor.transporGrafo();
    }

}

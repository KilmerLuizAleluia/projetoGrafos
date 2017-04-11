package estrutura;

import enums.Cor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertice {

    private static int MOMENTO = 0;

    private String nome;
    private List<Aresta> arestas = new ArrayList<Aresta>();
    private Cor cor = Cor.BRANCO;
    private int momentoDescoberta;
    private int momentoFinalizacao;
    private Vertice pai;

    public Vertice() {
    }

    public Vertice(String nome) {
        this.nome = nome;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMomentoDescoberta() {
        return momentoDescoberta;
    }

    public void setMomentoDescoberta(int momentoDescoberta) {
        this.momentoDescoberta = momentoDescoberta;
    }

    public int getMomentoFinalizacao() {
        return momentoFinalizacao;
    }

    public void setMomentoFinalizacao(int momentoFinalizacao) {
        this.momentoFinalizacao = momentoFinalizacao;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public void addArestas(Aresta... aresta) {
        arestas.addAll(Arrays.asList(aresta));
    }

    private boolean hasArestas() {
        return !arestas.isEmpty();
    }

    static void incrementarMomento() {
        MOMENTO++;
    }

    public void dfs() {

        if (hasArestas()) {
            setMomentoDescoberta(MOMENTO);
            setCor(Cor.CINZA);
            System.out.println("Momento: " + MOMENTO + "; estrutura.Vertice " + nome + ": CINZA");

            for (Aresta aresta : arestas) {
                if (verticeJaPercorrido(aresta)) {
                    break;
                }
                MOMENTO++;
                aresta.getVerticesChegada().setPai(this);
                aresta.getVerticesChegada().dfs();
            }

        }
        MOMENTO++;
        System.out.println("Momento: " + MOMENTO + "; estrutura.Vertice " + nome + ": PRETO");
        setMomentoFinalizacao(MOMENTO);
        setCor(Cor.PRETO);

    }

    private boolean verticeJaPercorrido(Aresta aresta) {
        return !aresta.getVerticesChegada().getCor().equals(Cor.BRANCO);
    }

}

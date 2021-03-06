package entidades;

import enums.Cor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Vertice {

    private static int MOMENTO = 0;

    private String nome;
    private Cor cor = Cor.BRANCO;
    private int momentoDescoberta;
    private int momentoFinalizacao;
    private Vertice pai;
    private List<Aresta> arestas = new ArrayList<>();

    private List<Aresta> arestasSaindo = new ArrayList<>();

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

    public static int getMOMENTO() {
        return MOMENTO;
    }

    public static void setMOMENTO(int MOMENTO) {
        Vertice.MOMENTO = MOMENTO;
    }

    public List<Aresta> getArestasSaindo() {
        return arestasSaindo;
    }

    public void setArestasSaindo(List<Aresta> arestasSaindo) {
        this.arestasSaindo = arestasSaindo;
    }

    public void addArestas(Aresta... aresta) {
        arestas.addAll(Arrays.asList(aresta));
        atualizarArestasSaindo();
    }

    public boolean hasArestasSaindo() {
        return !arestasSaindo.isEmpty();
    }

    public static void incrementarMomento() {
        MOMENTO++;
    }

    public static void inicializarMomento() {
        MOMENTO = 0;
    }

    public void atualizarArestasSaindo() {
        arestasSaindo = arestas.stream()
                .filter(a -> a.getVerticesPartida().getNome().equals(this.getNome()))
                .collect(Collectors.toList());
    }
}

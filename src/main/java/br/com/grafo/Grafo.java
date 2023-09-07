package br.com.grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Individuo> vertices;
    private List<Contato> arestas;

    public Grafo() {
    }

    public Grafo(List<Individuo> vertices, List<Contato> aresta) {
        this.vertices = vertices;
        this.arestas = aresta;
    }

    public void adicionarVertice(Individuo individuo) {
        this.vertices.add(individuo);
    }

    public void adicionarAresta(Individuo origem, Individuo destino) {
        Contato aresta = new Contato(origem, destino);
        this.arestas.add(aresta);
    }

    public List<Individuo> obterVizinhos(Individuo individuo) {
        List<Individuo> vizinhos = new ArrayList<>();
        for (Contato aresta : this.arestas) {
            if (aresta.getIndividuoOrigem().equals(individuo)) {
                vizinhos.add(aresta.getIndividuoDestino());
            }
        }
        return vizinhos;
    }

    public Integer getNumeroVertices(){
        return this.vertices.size();
    }

    public Integer getIndiceVertice(Individuo individuo){
        return this.vertices.indexOf(individuo);
    }

    List<Individuo> listarAsjacencias(Individuo individuo){
        List<Individuo> adjacentes = new ArrayList<>(this.getNumeroVertices());
        for(Contato contato: this.arestas){
            if (contato.getIndividuoOrigem().equals(individuo)){
                adjacentes.add(contato.getIndividuoDestino());
            }
        }
        return adjacentes;
    }
    public void imprimir() {
        if (this.arestas != null) {
            for (Contato aresta : this.arestas) {
                System.out.println(aresta + "\t");
            }
            System.out.println("");
        } else {
            System.out.println("Sem arestas!");
        }
    }

    public List<Individuo> getVertices() {
        return vertices;
    }

    public void setVertices(List<Individuo> vertices) {
        this.vertices = vertices;
    }

    public List<Contato> getArestas() {
        return arestas;
    }

    public void setArestas(List<Contato> arestas) {
        this.arestas = arestas;
    }
}

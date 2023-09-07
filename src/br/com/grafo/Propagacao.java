package br.com.grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Representa a classe de busca em largura (BFS)
public class Propagacao {
    private Grafo grafo;
    private List<Cor> cores;
    private List<Integer> distancia;
    private List<Integer> pai;

    public Propagacao(Grafo grafo) {
        this.grafo = grafo;
        int numVertices = grafo.getNumeroVertices();
        this.cores = new ArrayList<>(numVertices);
        this.distancia = new ArrayList<>(numVertices);
        this.pai = new ArrayList<>(numVertices);

        // Preencha as listas com valores iniciais, por exemplo, adicione null para cada elemento.
        for (int i = 0; i < numVertices; i++) {
            this.cores.add(null);
            this.distancia.add(null);
            this.pai.add(null);
        }
    }


    public void inicializar() {
        for (int i = 0; i < grafo.getNumeroVertices(); i++) {
            this.cores.set(i, Cor.BRANCO);
            this.distancia.set(i, -1);
            this.pai.set(i, -1);
        }
    }

    public void execute(Individuo individuo){
        Integer indice = this.grafo.getIndiceVertices(individuo);
        inicializar();
        PriorityQueue<Individuo> fila = new PriorityQueue<>();
        this.cores.set(indice, Cor.CINZA);
        this.distancia.set(indice, 0);
        fila.add(individuo);

        while (fila.size() > 0){
            Individuo v = fila.poll();
            List<Individuo> adjacenciaV = this.grafo.listarAsjacencias(v);
            for (Individuo u: adjacenciaV){
                Integer indiceU = this.grafo.getIndiceVertices(u);
                if (this.cores.get(indiceU) == Cor.BRANCO){
                    this.pai.set(indiceU, indice);
                    this.distancia.set(indiceU, this.distancia.get(indice)+1);
                    this.cores.set(indiceU, Cor.CINZA);
                    fila.add(u);
                }
            }
        }

    }

    public void imprimir() {
        System.out.println("Cores");
        for(Cor c : this.cores)
            System.out.print(c + " ");
        System.out.println("\nPai");
        for(int p : this.pai)
            System.out.print(p + " ");
        System.out.println("\nDistancia");
        for(int d : this.distancia)
            System.out.print(d + " ");
        System.out.println("");
    }
}

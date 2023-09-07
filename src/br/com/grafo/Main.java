package br.com.grafo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando cálculo da epidemia...");

        Grafo grafo = new Grafo();
        grafo.imprimir();

        // A -> B -> C -> D
        Individuo a = new Individuo(1L, "A", true);
        Individuo b = new Individuo(2L, "B", false);
        Individuo c = new Individuo(3L, "C", false);
        Individuo d = new Individuo(4L, "D", false);

        List<Individuo> individuos = new ArrayList<>();
        individuos.add(a);
        individuos.add(b);
        individuos.add(c);
        individuos.add(d);

        List<Contato> rede = new ArrayList<>();
        rede.add(new Contato(a, b));
        rede.add(new Contato(b, c));
        rede.add(new Contato(c, d));

        grafo.setVertices(individuos);
        grafo.setArestas(rede);

        Propagacao propagacao = new Propagacao(grafo);
        propagacao.execute(a);

        propagacao.imprimir();
    }
}

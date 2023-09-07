package br.com.grafo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando cálculo da epidemia...");

        Grafo grafo = new Grafo();
        grafo.imprimir();

        // Exemplo do doc
        Individuo um = new Individuo(1L, "A", false);
        Individuo dois = new Individuo(2L, "B", false);
        Individuo tres = new Individuo(3L, "C", false);
        Individuo quatro = new Individuo(4L, "D", false);
        Individuo cinco = new Individuo(5L, "E", false);
        Individuo seis = new Individuo(6L, "F", false);
        Individuo sete = new Individuo(7L, "G", false);
        Individuo oito = new Individuo(8L, "H", false);
        Individuo nove = new Individuo(9L, "I", true);
        Individuo dez = new Individuo(10L, "J", false);
        Individuo onze = new Individuo(11L, "K", false);

        List<Individuo> individuos = new ArrayList<>();
        individuos.add(um);
        individuos.add(dois);
        individuos.add(tres);
        individuos.add(quatro);
        individuos.add(cinco);
        individuos.add(seis);
        individuos.add(sete);
        individuos.add(oito);
        individuos.add(nove);
        individuos.add(dez);
        individuos.add(onze);

        List<Contato> rede = new ArrayList<>();
        rede.add(new Contato(nove, dez));
        rede.add(new Contato(nove, quatro));
        rede.add(new Contato(nove, onze));
        rede.add(new Contato(quatro, um));
        rede.add(new Contato(quatro, sete));
        rede.add(new Contato(quatro, dois));
        rede.add(new Contato(quatro, oito));
        rede.add(new Contato(um, tres));
        rede.add(new Contato(dois, cinco));
        rede.add(new Contato(dois, seis));

        grafo.setVertices(individuos);
        grafo.setArestas(rede);

        Propagacao propagacao = new Propagacao(grafo);
        propagacao.execute(nove);

        propagacao.imprimir();

        //saida
        //10, 4, 11
        //1, 7, 2, 8
        //3, 5, 6
    }
}

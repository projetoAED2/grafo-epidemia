package br.com.grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Representa a classe de busca em largura (BFS)
public class Propagacao {
    private Grafo grafo;
    private List<Individuo> propagacao = new ArrayList<>();
    private Integer grauMaximo = 0;

    public Propagacao(Grafo grafo) {
        this.grafo = grafo;
    }

    public void execute(Individuo individuo){
        PriorityQueue<Individuo> fila = new PriorityQueue<>();
        individuo.setCor(Cor.CINZA);
        fila.add(individuo);

        int grau = 0;
        while (fila.size() > 0){
            Individuo v = fila.poll();
            List<Individuo> adjacenciaV = this.grafo.listarAsjacencias(v);
            for (Individuo u: adjacenciaV){
                if (u.getCor() == Cor.BRANCO){
                    this.propagacao.add(u);
                    u.setCor(Cor.CINZA);
                    u.setGrauInfectado(grau);
                    fila.add(u);
                }
            }
            grau++;
        }
        this.grauMaximo = grau;
    }

    public void imprimir() {
        System.out.println("---------------- Ordem de propagação: ----------------");
        for (Individuo individuo: this.propagacao) {
            System.out.println("Código: " + individuo.getCodigo());
            System.out.println("Nome: " + individuo.getNome());
            System.out.println("Grau infecção: " + individuo.getGrauInfectado());
            System.out.println("-------------------------");
        }
    }
}

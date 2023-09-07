package br.com.grafo;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nIniciando cálculo da epidemia...\n");
        //saida grau[grupo], ex: 1[2, 3, 4]; grau 1, grupo 2, 3, 4;
        //saida 1[10, 4, 11]; 2[1, 7, 2, 8]; 3[3, 5, 6]
        Execucao.executarTeste("teste01-vertices.json", "teste01-arestas.json", 9L);
        //saida 1[2]; 2[4, 5]; 3[9, 1, 7, 8]; 4[3, 10, 11]
        Execucao.executarTeste("teste01-vertices.json", "teste01-arestas.json", 6L);
        //saida 1[9, 1, 7, 2, 8]; 2[3, 5, 6, 10, 11]
        Execucao.executarTeste("teste01-vertices.json", "teste01-arestas.json", 4L);

        //TODO menu para usuário adicionar informações na mão
        //TODO adicionar os demais casos de teste a partir do grafo exemplo (as origens que faltam
        //TODO acrescentar ou não mais variáveis (se fizer lembrar de modificar o slide e os métodos de print)
        //TODO incrementar mais algo na lógica da execução na classe Propagacao, pode ser de acordo com alguma variável nova do individuo
        //TODO remover codigo não utilizado
    }
}

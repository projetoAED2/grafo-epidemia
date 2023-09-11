package br.com.grafo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileVertices = "teste01-vertices.json"; 
        String fileArestas = "teste01-arestas.json"; 

        Grafo grafo = new Grafo();

        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Rastrear a propagação da doença a partir de uma pessoa infectada");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                int escolha = scanner.nextInt();

                if (escolha == 1) {
                    System.out.print("Digite o código da pessoa infectada: ");
                    Long codigoInfectado = scanner.nextLong();

                    Execucao.executarTeste(fileVertices, fileArestas, codigoInfectado);
                } else if (escolha == 2) {
                    System.out.println("Saindo do programa.");
                    break;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Certifique-se de inserir um número válido.");
                scanner.next();
            }
        }

        scanner.close();
    }
}

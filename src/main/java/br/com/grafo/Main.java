package br.com.grafo;

import java.util.Scanner;

public class Main {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int opcao;

	        Execucao.inicializarDados("vertices.json", "arestas.json");

	        do {
	            System.out.println("\nOpções:");
	            System.out.println("1. Listar todas as pessoas infectadas");
	            System.out.println("2. Rastreamento a partir de uma pessoa infectada");
	            System.out.println("3. Sair");
	            System.out.print("Escolha uma opção: ");

	            opcao = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcao) {
	                case 1:
	                    Execucao.listarTodasPessoas();
	                    break;
	                case 2:
	                    System.out.print("Digite o código da pessoa infectada: ");
	                    Long codIndividuoOrigem = scanner.nextLong();
	                    Execucao.executarTeste(codIndividuoOrigem);
	                    Execucao.zerarGrauInfeccao(Execucao.listaTodasPessoas);
	                    break;
	                case 3:
	                    System.out.println("Saindo...");
	                    break;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	                    break;
	            }
	        } while (opcao != 3);

	        scanner.close();
	    }
}

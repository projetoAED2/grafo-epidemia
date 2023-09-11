package br.com.grafo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Execucao {

    static List<Individuo> listaTodasPessoas = new ArrayList<>(); 

    public static void inicializarDados(String fileVertices, String fileArestas) {
        JSONArray jsonArray;
        List<Individuo> individuos = new ArrayList<>();
        jsonArray = readJson(fileVertices);
        for (int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            long codigo = jsonObject.getLong("codigo");
            String nome = jsonObject.getString("nome");
            Individuo individuo = new Individuo(codigo, nome);
            individuos.add(individuo);
        }

        listaTodasPessoas.addAll(individuos);

        List<Contato> rede = new ArrayList<>();
        jsonArray = readJson(fileArestas);
        for (int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            long codigoOrigem = jsonObject.getLong("codigoOrigem");
            long codigoDestino = jsonObject.getLong("codigoDestino");
            Individuo individuoOrigem = Utils.encontrarIndividuoPorCodigo(individuos, codigoOrigem);
            Individuo individuoDestino = Utils.encontrarIndividuoPorCodigo(individuos, codigoDestino);
            rede.add(new Contato(individuoOrigem, individuoDestino));
        }
    }

    public static void executarTeste(Long codIndividuoOrigem) {
        System.out.println("\nIniciando teste...");
        Grafo grafo = new Grafo();
        grafo.imprimir();

        List<Individuo> individuos = new ArrayList<>();
        individuos.addAll(listaTodasPessoas);

        Individuo individuo = Utils.encontrarIndividuoPorCodigo(individuos, codIndividuoOrigem);

        if (individuo != null) {
            grafo.setVertices(individuos);
            grafo.setArestas(listaTodasArestas());

            Propagacao propagacao = new Propagacao(grafo);
            propagacao.execute(individuo);

            propagacao.imprimir();
        } else {
            System.out.println("Individuo informado não existe!");
        }
    }

    public static void listarTodasPessoas() {
    	System.out.println("\n---------------- Lista de pessoas infectadas: ----------------");
        for (Individuo individuo : listaTodasPessoas) {
            System.out.println("Código: " + individuo.getCodigo());
            System.out.println("Nome: " + individuo.getNome());
            System.out.println("-------------------------");
        }
    }

    private static JSONArray readJson(String file) {
        try {
            String json = Files.readString(Paths.get("src/main/java/resources/" + file));
            return new JSONArray(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<Contato> listaTodasArestas() {
        List<Contato> todasArestas = new ArrayList<>();
        List<Individuo> individuos = new ArrayList<>(listaTodasPessoas);

        JSONArray jsonArray = readJson("arestas.json");
        for (int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            long codigoOrigem = jsonObject.getLong("codigoOrigem");
            long codigoDestino = jsonObject.getLong("codigoDestino");
            Individuo individuoOrigem = Utils.encontrarIndividuoPorCodigo(individuos, codigoOrigem);
            Individuo individuoDestino = Utils.encontrarIndividuoPorCodigo(individuos, codigoDestino);
            todasArestas.add(new Contato(individuoOrigem, individuoDestino));
        }

        return todasArestas;
    }
    
    public static void zerarGrauInfeccao(List<Individuo> individuos) {
        for (Individuo individuo : individuos) {
            individuo.setGrauInfectado(0);
        }
    }
}
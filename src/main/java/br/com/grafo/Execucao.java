package br.com.grafo;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.transform.Source;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Execucao {

    public static void executarTeste(String fileVertices, String fileArestas, Long codIndividuoOrigem) {
        System.out.println("\nIniciando teste...");
        JSONArray jsonArray;
        Grafo grafo = new Grafo();
        grafo.imprimir();

        List<Individuo> individuos = new ArrayList<>();
        jsonArray = readJson(fileVertices);
        System.out.println("Adicionando Individuos (vertices)...");

        for (int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            long codigo = jsonObject.getLong("codigo");
            String nome = jsonObject.getString("nome");
            Individuo individuo = new Individuo(codigo, nome);
            individuos.add(individuo);
        }

        List<Contato> rede = new ArrayList<>();
        jsonArray = readJson(fileArestas);
        System.out.println("Adicionando Contatos (arestas)...");

        for (int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            long codigoOrigem = jsonObject.getLong("codigoOrigem");
            long codigoDestino = jsonObject.getLong("codigoDestino");
            Individuo individuoOrigem = Utils.encontrarIndividuoPorCodigo(individuos, codigoOrigem);
            Individuo individuoDestino = Utils.encontrarIndividuoPorCodigo(individuos, codigoDestino);
            rede.add(new Contato(individuoOrigem, individuoDestino));
        }

        grafo.setVertices(individuos);
        grafo.setArestas(rede);

        Propagacao propagacao = new Propagacao(grafo);

        Individuo individuo = Utils.encontrarIndividuoPorCodigo(individuos, codIndividuoOrigem);
        if (individuo != null) {
            propagacao.execute(individuo);
            propagacao.imprimir();
        } else {
            System.out.println("Individuo informado não existe!");
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


}

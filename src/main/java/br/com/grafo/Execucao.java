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

    //saida teste 01
    //10, 4, 11
    //1, 7, 2, 8
    //3, 5, 6
    public static void executarTeste01() {

        JSONArray jsonArray;
        Grafo grafo = new Grafo();
        grafo.imprimir();

        List<Individuo> individuos = new ArrayList<>();
        jsonArray = readJson("teste01-vertices.json");
        System.out.println("Adicionando Individuos (vertices)...");

        for (int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            long codigo = jsonObject.getLong("codigo");
            String nome = jsonObject.getString("nome");
            Individuo individuo = new Individuo(codigo, nome);
            individuos.add(individuo);
        }

        List<Contato> rede = new ArrayList<>();
        jsonArray = readJson("teste01-arestas.json");
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
        propagacao.execute(Objects.requireNonNull(Utils.encontrarIndividuoPorCodigo(individuos, 9L)));

        propagacao.imprimir();
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

package br.com.grafo;

//Class aresta
public class Contato {
    private Individuo individuoOrigem;
    private Individuo individuoDistino;

    public Contato(Individuo individuoEntrada, Individuo individuoSaida) {
        this.individuoOrigem = individuoEntrada;
        this.individuoDistino = individuoSaida;
    }

    public Individuo getIndividuoOrigem() {
        return individuoOrigem;
    }

    public void setIndividuoOrigem(Individuo individuoOrigem) {
        this.individuoOrigem = individuoOrigem;
    }

    public Individuo getIndividuoDistino() {
        return individuoDistino;
    }

    public void setIndividuoDistino(Individuo individuoDistino) {
        this.individuoDistino = individuoDistino;
    }
}

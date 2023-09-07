package br.com.grafo;

//Class aresta
public class Contato {
    private Individuo individuoOrigem;
    private Individuo individuoDestino;

    public Contato(Individuo individuoEntrada, Individuo individuoSaida) {
        this.individuoOrigem = individuoEntrada;
        this.individuoDestino = individuoSaida;
    }

    public Individuo getIndividuoOrigem() {
        return individuoOrigem;
    }

    public void setIndividuoOrigem(Individuo individuoOrigem) {
        this.individuoOrigem = individuoOrigem;
    }

    public Individuo getIndividuoDestino() {
        return individuoDestino;
    }

    public void setIndividuoDestino(Individuo individuoDestino) {
        this.individuoDestino = individuoDestino;
    }
}

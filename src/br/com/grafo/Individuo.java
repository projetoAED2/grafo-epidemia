package br.com.grafo;

//Class Vertice
public class Individuo implements Comparable<Individuo>{
    private Long codigo;
    private String nome;
    private Boolean infectado;
    private Cor cor = Cor.BRANCO;

    public Individuo(Long codigo, String nome, Boolean infectado) {
        this.codigo = codigo;
        this.nome = nome;
        this.infectado = infectado;
    }

    public Long getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public Boolean getInfectado() {
        return this.infectado;
    }

    public Cor getCor() {
        return this.cor;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public void setInfectado(Boolean infectado) {
        this.infectado = infectado;
    }

    @Override
    public int compareTo(Individuo outro) {
        // Comparação pelo código
        int resultado = this.codigo.compareTo(outro.codigo);
        // Se os códigos são iguais, compare pelo nome
        if (resultado == 0) {
            resultado = this.nome.compareTo(outro.nome);
        }
        // Se o nome também é igual, compare pelo estado de infectado (true antes de false)
        if (resultado == 0) {
            resultado = Boolean.compare(outro.infectado, this.infectado);
        }
        return resultado;
    }
}

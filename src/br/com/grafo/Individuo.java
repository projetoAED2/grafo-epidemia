package br.com.grafo;

//Class Vertice
public class Individuo {
    private Long codigo;
    private String nome;
    private Boolean infectado;

    public Individuo(Long codigo, String nome, Boolean infectado) {
        this.codigo = codigo;
        this.nome = nome;
        this.infectado = infectado;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getInfectado() {
        return infectado;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setInfectado(Boolean infectado) {
        this.infectado = infectado;
    }
}

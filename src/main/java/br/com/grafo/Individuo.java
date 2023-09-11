package br.com.grafo;

//Class Vertice
public class Individuo implements Comparable<Individuo>{
    private Long codigo;
    private String nome;
    private Integer grauInfectado = 0;
    private Cor cor = Cor.BRANCO;

    public Individuo(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Long getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public Cor getCor() {
        return this.cor;
    }

    public Integer getGrauInfectado() {
        return this.grauInfectado;
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

    public void setGrauInfectado(Integer grauInfectado) {
        this.grauInfectado = grauInfectado;
    }

    @Override
    public int compareTo(Individuo outro) {
        int resultado = this.codigo.compareTo(outro.codigo);
        if (resultado == 0) {
            resultado = this.nome.compareTo(outro.nome);
        }
        return resultado;
    }

}

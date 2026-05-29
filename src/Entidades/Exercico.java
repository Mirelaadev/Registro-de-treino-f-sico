package Entidades;

public class Exercico {
    private String nome;
    private int series;
    private int repeticoes;
    private String observacoes;

    public Exercico() {
    }

    public Exercico(String nome, int series, int repeticoes, String observacoes) {
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
        this.observacoes = observacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void exibirExercicio() {
        System.out.println("Nome do exercício: " + getNome());
        System.out.println("Quantidade de séries: " + getSeries());
        System.out.println("Quantidade de repetições: " + getRepeticoes());
        System.out.println("Observações: " + getObservacoes());
    }
}
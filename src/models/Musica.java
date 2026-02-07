package models;

public class Musica {
    private String nome;
    private int duracao;

    public Musica(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public String getDuracao() {
        int minito = duracao / 60;
        int segundo = duracao % 60;
        return (minito+":" +segundo);
    }
}

package models;

public class Site {
    private String nome;
    private String url;
    private String horario;

    public Site(String nome, String url, String horario) {
        this.nome = nome;
        this.url = url;
        this.horario = horario;
    }

    public void mostrarSite(){
        System.out.println("Você acessou o " + this.nome);
    }

    public void mostrarSiteHistorico(){
        System.out.println(this.url + " " + this.horario);
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}

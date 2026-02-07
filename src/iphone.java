import models.Musica;
import models.Site;
import view.Navegador;
import view.ReprodutorMusical;
import view.Telefone;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class iphone implements ReprodutorMusical, Telefone, Navegador {
    public void main(String[] args) {
        //Musicas iniciais
        listaMusicas.add(new Musica("Fibonacci", 131));
        listaMusicas.add(new Musica("Singular", 162));
        listaMusicas.add(new Musica("Coração de Ferro", 192));

        listaSites.add(new Site("Youtube", "www.youtube.com", "0"));
        listaSites.add(new Site("Dio", "www.dio.com", "0"));
        listaSites.add(new Site("Github", "www.github.com", "0"));
        listaSites.add(new Site("ChatGPT", "www.chatgpt.com", "0"));
        listaSites.add(new Site("Shoppe", "www.shoope.com", "0"));
        listaSites.add(new Site("Linkedin", "www.linkedin.com", "0"));

        telaInicial();
    }

    public void telaInicial(){
        System.out.println("Inicio");
        System.out.println("1 - Reprodutor Musical");
        System.out.println("2 - Telefone");
        System.out.println("3 - Navegador de internet");

        Scanner ler = new Scanner(System.in);

        int option = ler.nextInt();
        switch(option){
            case 1:
                telaReprodutorMusical();
                break;
            case 2:
                telaTelefone();
                break;
            case 3:
                telaNavegador();
                break;
            default:
                telaInicial();
                break;
        }
    }


    //Reprodutor Musical

    //variaveis
    public List<Musica> listaMusicas = new ArrayList<>();
    public int musicaAtual = 0;
    public boolean tacandoMusica = false;
    //metodos
    @Override
    public void telaReprodutorMusical() {
        System.out.println("Reprodutor Musical");
        System.out.println("1 - Play / Pause");
        System.out.println("2 - Selecionar Musica");
        System.out.println("3 - Avançar Musica");
        System.out.println("4 - Voltar Musica");
        System.out.println("5 - Voltar ao Menu");

        Scanner ler = new Scanner(System.in);
        int option  = ler.nextInt();

        switch(option){
            case 1:
                if(tacandoMusica){
                    pararMusica();
                    tacandoMusica = false;
                }else{
                    tocarMusica();
                    tacandoMusica = true;
                }
                telaReprodutorMusical();
                break;
            case 2:
                selecionarMusica();
                break;
            case 3:
                avancarMusica();
                telaReprodutorMusical();
                break;
            case 4:
                voltarMusica();
                telaReprodutorMusical();
                break;
            case 5:
                telaInicial();
                break;
                default:
                    telaReprodutorMusical();
        }
    }
    public void tocarMusica() {
        Musica musica = listaMusicas.get(musicaAtual);
        System.out.println("tocando " + musica.getNome() + " Duração: " + musica.getDuracao());
    }
    public void pararMusica() {
        Musica musica = listaMusicas.get(musicaAtual);
        System.out.println("Pausando " + musica.getNome() + " Duração: " + musica.getDuracao());
    }
    public void selecionarMusica() {
        AtomicInteger index = new AtomicInteger();
        listaMusicas.forEach((musica) -> {
            System.out.println((index.get() + 1) + " - "+ musica.getNome() + " - " + musica.getDuracao());
            index.addAndGet(1);
        });

        Scanner ler = new Scanner(System.in);
        System.out.println("Digite uma musica que deseja selecionar: ");
        int option = ler.nextInt();

        musicaAtual = (option - 1);
        tocarMusica();
        telaReprodutorMusical();
    }
    public void avancarMusica() {
        musicaAtual++;
        if(musicaAtual == listaMusicas.size()){
            musicaAtual = 0;
        }
        tocarMusica();
    }
    public void voltarMusica() {
        musicaAtual--;
        if(musicaAtual < 0){
            musicaAtual = listaMusicas.size()-1;
        }
        tocarMusica();
    }

    //Telefone
    //metodos
    @Override
    public void telaTelefone(){
        System.out.println("Telefone");
        System.out.println("1 - Ligar");
        System.out.println("2 - Atender");
        System.out.println("3 - Caixa de Correio");
        System.out.println("4 - Voltar ao Menu");

        Scanner ler = new Scanner(System.in);
        int option = ler.nextInt();
        switch(option){
            case 1:
                ligar();
                break;
            case 2:
                atender();
                break;
            case 3:
                caixaDeMensagens();
                telaTelefone();
                break;
            case 4:
                telaInicial();
            default:
                telaTelefone();
        }
    }
    public void ligar(){
        System.out.println("digite o numero de telefone:");
        Scanner ler = new Scanner(System.in);
        String telefone = ler.nextLine();

        if(telefone.length() == 11 && telefone.substring(0, 3).equals("119")){
            mensagemAleatoriaLigar();
            telaTelefone();
        }else{
            System.out.println("Numero de telefone invalido");
        }



    }
    public void atender(){
        Random random = new Random();

        if(random.nextBoolean()){
            mensagemAleatoriaLigar();
        }else{
            System.out.println("Voce nao esta recebendo uma chamada");
        }
        telaTelefone();
    }
    public void caixaDeMensagens(){
        Random random = new Random();

        List<String> mensagens = new ArrayList<>();
        mensagens.add("Rubens queria conversar sobre Valorant");
        mensagens.add("Rubens queria conversar sobre Programação");
        mensagens.add("Rubens queria conversar sobre Comida");
        mensagens.add("Hamamoto queria conversar sobre Monster");
        mensagens.add("Hamamoto queria conversar sobre Fortnite");
        mensagens.add("Hamamoto queria conversar sobre Rodizio");
        mensagens.add("Rhian queria conversar sobre Senai");
        mensagens.add("Rhian queria conversar sobre Valorant");
        mensagens.add("Rhian queria conversar sobre Fotebol");

        System.out.println(mensagens.get(random.nextInt(mensagens.size())));
    }
    public void mensagemAleatoriaLigar(){
        Random random = new Random();

        List<String> mensagens = new ArrayList<>();
        mensagens.add("Voce conversou com Rubens por 1h");
        mensagens.add("Voce conversou com Rubens por 2h");
        mensagens.add("Voce conversou com Rubens por 3h");
        mensagens.add("Voce conversou com Hamamoto por 1h");
        mensagens.add("Voce conversou com Hamamoto por 2h");
        mensagens.add("Voce conversou com Hamomoto por 3h");
        mensagens.add("Voce conversou com Rhian por 1h");
        mensagens.add("Voce conversou com Rhian por 2h");
        mensagens.add("Voce conversou com Rhian por 3h");
        mensagens.add("Voce conversou com Caua por 1h");
        mensagens.add("Voce conversou com Caua por 2h");
        mensagens.add("Voce conversou com Caua por 3h");
        mensagens.add("Voce conversou com Maria por 1h");
        mensagens.add("Voce conversou com Maria por 2h");
        mensagens.add("Voce conversou com Maria por 3h");

        System.out.println(mensagens.get(random.nextInt(mensagens.size())));
    }

    //Navegador de internet

    //variaveis
    public List<Site> listaSites =  new ArrayList<>();
    public List<Site> historiocoSites =  new ArrayList<Site>();
    //metodos
    public void telaNavegador(){
        System.out.println("Navegador");
        System.out.println("1 - Pesquisar");
        System.out.println("2 - Historico");
        System.out.println("3 - Voltar ao inicio");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1:
                pesquisar();
                break;
            case 2:
                historico();
                break;
            case 3:
                telaInicial();
                break;
            default:
                telaNavegador();

        }
    }
    public void pesquisar(){
        Random random = new Random();
        Site site = listaSites.get(random.nextInt(listaSites.size()));

        LocalTime horario = LocalTime.now();

        site.setHorario(horario.toString());
        historiocoSites.add(site);
        site.mostrarSite();
        telaNavegador();
    }
    public void historico(){
        for(Site site : historiocoSites){
            site.mostrarSiteHistorico();

        }
        telaNavegador();
    }
}

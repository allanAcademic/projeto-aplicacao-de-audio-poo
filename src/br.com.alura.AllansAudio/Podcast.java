package br.com.alura.AllansAudio;

public class Podcast extends Audio implements Painel {
    private String canal;
    private String tema;
    private boolean contemVideo;

    //Getters e setters
    public String getCanal() {
        return canal;
    }
    public void setCanal(String canal) {
        this.canal = canal;
    }
    public String getTema(){
        return tema;
    }
    public void setTema(String tema){
        this.tema = tema;
    }
    public boolean getContemVideo() {
        return contemVideo;
    }
    public void setContemVideo(boolean contemVideo) {
        this.contemVideo = contemVideo;
    }

    //Override superclasse
    @Override
    public void curtir(){
        System.out.println("Você curtiu esse podcast. Adicionamos ele na playlist de podcast curtidos");
        setCurtido(true);
    }
    @Override
    public void descurtir(){
        System.out.println("Tiramos esse episódio de podcast da playlist curtido");
        setCurtido(false);
    }
    //Overrides interfaces
    @Override
    public void painelReproducao(){
        System.out.printf("""
                
                
                REPRODUZINDO EPISÓDIO DO PODCAST:
                Título: %s
                Duração:%g
                Canal: %s
     
     
                """,getTitulo(), getDuracao(), getCanal());
    }
    @Override
    public void painelInformacoes(){
        System.out.printf("""
                
                
                INFORMAÇÕES DETALHADAS:
                Título: %s
                Duração:%.1f
                Canal: %s
                Tema: %s
                Canal: %s
                Ano: %d
                Total de reproduções: %d
                Avaliacão: %d
                Curtido: %s
                
                
                """,getTitulo(), getDuracao(), getCanal(), getTema(), getCanal(), getAno(), getTotalReproducoes(), getClassificacao(), eCurtido());
    }

    //Métodos exclusivos
    public void versaoVideo(){
        if(getContemVideo() == true) {
            System.out.println("Reproduzindo a versão de vídeo do podcast");
        } else{
            System.out.println("Vídeo não disponível");
        }
    }
    }


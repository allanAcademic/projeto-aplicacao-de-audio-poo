package br.com.alura.AllansAudio;

public class Musica extends Audio implements Painel{

    private String artista;
    private String album;

    //Getters e setter
    public String getArtista() {

        return artista;
    }
    public void setArtista(String artista)
    {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {

        this.album = album;
    }

    //Overrides superclasse
    @Override
    public void curtir(){
        System.out.println("Você curtiu essa música. Adicionamos ela na playlist de músicas curtidas");
        setCurtido(true);
    }
    @Override
    public void descurtir(){
        System.out.println("Tiramos essa música da playlist curtido");
        setCurtido(false);
    }
    //Overrides interfaces
    @Override
    public void painelReproducao(){
        System.out.printf("""
                
                
                REPRODUZINDO MÚSICA:
                Título: %s
                Duração:%g
                Artista: %s
                Album: %s
                
                
                """,getTitulo(), getDuracao(), getArtista(), getAlbum());
    }
    @Override
    public void painelInformacoes(){
        System.out.printf("""
                
                INFORMAÇÕES DETALHADAS:
                Título: %s
                Duração:%.1f
                Artista: %s
                Album: %s
                Ano: %d
                Classificacao: %d
                Total de reproduções: %d
                Curtido: %s
                
                
                """,getTitulo(), getDuracao(), getArtista(), getAlbum(), getAno(), getClassificacao(), getTotalReproducoes(), eCurtido() );
    }

    //Métodos exclusivos
    public void sugestoesSemelhantes(){
        System.out.println("Aqui estão algumas músicas semelhantes: ");
        System.out.println("""
                - MÚSICA 1
                - MÚSICA 2
                - MÚSICA 3
                """);
    }
}

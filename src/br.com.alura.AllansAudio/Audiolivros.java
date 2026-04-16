package br.com.alura.AllansAudio;

public class Audiolivros extends Audio implements Painel{
    private String autor;
    private int capitulos;
    private String colecao = "Sem coleção";
    private String genero;
    private double preco = 0;
    private int capituloAtual;


    //Getters e setters
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getCapitulos() {

        return capitulos;
    }
    public void setCapitulos(int capitulos) {

        this.capitulos = capitulos;
    }
    public String getColecao() {

        return colecao;
    }
    public void setColecao(String colecao) {

        this.colecao = colecao;
    }
    public String getGenero() {

        return genero;
    }
    public void setGenero(String genero) {

        this.genero = genero;
    }
    public double getPreco() {

        return preco;
    }
    public void setPreco(double preco) {

        this.preco = preco;
    }
    public int getCapituloAtual() {
        return capituloAtual;
    }
    public void setCapituloAtual(int capituloAtual) {
        this.capituloAtual = capituloAtual;
    }

    //Override superclasse
    @Override
    public void curtir() {
        super.curtir();
    }
    @Override
    public void descurtir(){
        System.out.println("Tiramos esse audioLivro da playlist curtido");
        setCurtido(false);
    }

    //Override interfaces
    @Override
    public void painelReproducao(){
        System.out.printf("""
                
                
                REPRODUZINDO CAPITULO DO AUDIOLIVRO:
                Livro: %s
                Duração do capítulo:%g
                Autor: %s
                Capitulo: %s

                """,getTitulo(), getDuracao(), getAutor(), getCapitulos());
    }
    @Override
    public void painelInformacoes(){
        System.out.printf("""
                
                INFORMAÇÕES DETALHADAS:
                Título: %s
                Autor: %s
                Duração total: %.1f
                Capitulos: %d
                Gênero: %s
                Coleção: %s
                Ano: %d
                Preço: %f
                Avalicao: %d
                Total de leituras: %d
                Curtido: %s
                
                
                """,getTitulo(), getAutor(), getDuracao(), getCapitulos(), getGenero(), getColecao(), getAno(), getPreco(), getClassificacao(), getTotalReproducoes(), eCurtido() );
    }

    //Métodos exclusivos
    public double progresso(){
        double i =  (double) (getCapituloAtual() / getCapitulos()) * 100;
        return i;
    }
}

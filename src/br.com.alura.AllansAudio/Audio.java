package br.com.alura.AllansAudio;

public abstract class Audio {
    //Criando atributos
    private String titulo;
    private double duracao;
    private int totalReproducoes;
    public int classificacao;
    public int ano;
    private boolean curtido = false;


    //Métodos getters e setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public double getDuracao() {
        return duracao;
    }
    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
    public int getTotalReproducoes() {
        return totalReproducoes;
    }
    public void setTotalReproducoes(int totalReproducoes) {
        this.totalReproducoes = totalReproducoes;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(int classificacao) {
        if(classificacao >= 0 && classificacao <6) {
            this.classificacao = classificacao;
        }
    }
    public boolean getCurtido(){
        return curtido;
    }
    public void setCurtido(boolean curtido){
        this.curtido = curtido;
    }

    //Métodos abstratos
    public void curtir(){
        System.out.println("Você curtiu esse audio. Adicionamos ela na playlist curtida");
        curtido = true;
    }
    public void descurtir(){
        System.out.println("Tiramos esse audio da pllaylist curtido");
        curtido = false;
    }
    public String eCurtido(){
        if(getCurtido() == true){
            return "Curtido";
        }else{
            return "Não curtido";
        }
        }
}

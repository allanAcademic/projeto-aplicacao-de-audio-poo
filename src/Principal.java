import br.com.alura.AllansAudio.Audio;
import br.com.alura.AllansAudio.Audiolivros;
import br.com.alura.AllansAudio.Musica;
import br.com.alura.AllansAudio.Painel;
import br.com.alura.AllansAudio.Podcast;

import java.util.ArrayList;
import java.util.Scanner;
public class Principal{

    public static void main(String[] args) {
        //Declaração dos objetos para instanciação posterior
        Scanner scanner = new Scanner(System.in);
        Audio escolha1 = null;
        //Criação de uma lista de objeto audio
        ArrayList<Audio> biblioteca = new ArrayList<>();
        //Declaração das variáveis que serão usadas para preencher os argumentos dos setters (e que poderão ser reusadas)
        String pegaTitulo;
        String autoria;
        double pegaDuracao;
        int pegaTotalReproducoes;
        int pegaClassificacao;
        int pegaAno;
        String respostaIf; //variável para condicionais e laços a fim de facilitar a lógica minha.
        //variáveis para escolhas do usuário
        int escolhaObjeto;
        int escolhaMenuDoObjeto;
        //variável para laços
        boolean j = true;
        boolean i = true;

        //Interação com usuário para escolha de qual objeto ele quer criar
        while (i) {
            j = true;//renovação do laço para true caso o usuário faça mais de um objeto e use o botão sair, possibilitando o menu do objeto funcionar
            System.out.println("""
                    Boas-vindas ao Allan's Music!
                    O que gostaria de fazer?
                    [1] - Adicionar música
                    [2] - Adicionar podcast
                    [3] - Adicionar audiolivro
                    [5] - Ver biblioteca completa
                    [4] - Sair do programa.
                    """);
            //armazenamento da escolha
            escolhaObjeto = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Por favor, preencha as seguintes informações: ");

            //Declaração dos atributos pelo usuário de acordo com sua escolha.
            switch (escolhaObjeto) {
                case 1: //Se a escolha for música
                    escolha1 = new Musica(); //Instanciação do objeto escolhido
                    System.out.println("Nome da música: "); //Padrão a ser repetido: sout para informar o usuário qual informação dar
                    pegaTitulo = scanner.nextLine(); // Padrão a ser repetido: scanner.next para armazenar o valor em variáveis re-utilizaveis.
                    ((Musica) escolha1).setTitulo(pegaTitulo); //Padrão a ser repetido: usar a variável como argumento do setter.

                    System.out.println("Artista da música: ");
                    autoria = scanner.nextLine();
                    ((Musica) escolha1).setArtista(autoria);

                    respostaIf = lerSimOuNao(scanner, "A música compõem um album, EP ou mixtape? (S/N)");
                    if (respostaIf.equalsIgnoreCase("S")) { //uso de condicionais para diferentes trechos de códigos
                        System.out.println("Informe o nome do álbum/EP/Mixtape: ");
                        String resposta = scanner.nextLine();
                        ((Musica) escolha1).setAlbum(resposta);
                    } else { //Exclusao do uso do if "n", pois o valor ja sai com apenas dois possiveis resultados
                        ((Musica) escolha1).setAlbum("Single");
                    }

                    System.out.println("Duração da música: ");
                    pegaDuracao = scanner.nextDouble();
                    ((Musica) escolha1).setDuracao(pegaDuracao);
                    scanner.nextLine(); //Limpando a linha para evitar erros de númericos com String na captação do Scanner.

                    System.out.println("Total de reproduções: ");
                    pegaTotalReproducoes = scanner.nextInt();
                    ((Musica) escolha1).setTotalReproducoes(pegaTotalReproducoes);
                    scanner.nextLine();

                    System.out.println("Nota da música (0-5): ");
                    pegaClassificacao = scanner.nextInt();
                    while (pegaClassificacao > 5 || pegaClassificacao < 0) { //Filtro caso a nota não esteja nos parametros de 0 a 5.
                        System.out.println("Digite uma classificação de 1-5");
                        pegaClassificacao = scanner.nextInt();
                    }
                    ((Musica) escolha1).setClassificacao(pegaClassificacao);
                    scanner.nextLine();
                    respostaIf = lerSimOuNao(scanner, "A música está entre as curtidas? (S/N)");
                    if (respostaIf.equalsIgnoreCase("S")) {
                        ((Musica) escolha1).setCurtido(true);
                    } else {
                        ((Musica) escolha1).setCurtido(false);
                    }

                    System.out.println("Ano de lançamento: ");
                    pegaAno = scanner.nextInt();
                    while (pegaAno < 1860 || pegaAno > 2027) { //Limitar valores do atributo ano para que seja desde a primeira gravação até 1 ano depois do atual, no caso de pré-lançamentos
                        System.out.println("Informe um ano entre 1860-2027");
                        pegaAno = scanner.nextInt();
                    }
                    ((Musica) escolha1).setAno(pegaAno);
                    scanner.nextLine();
                    //Após finalizado os atributos, da a opção de visualização e de usar os métodos
                    ((Painel) escolha1).painelInformacoes();
                    while (j) {//Criação de um while para que o trecho de código repita até o usuário pedir para finalizar
                        System.out.printf("""
                                Menu de %s
                                O que gostaria de fazer?
                                1 - Reproduzir
                                2- Ver informações detalhadas
                                3 - Sugestões semelhantes
                                4 - Adicionar/Retirar música de curtidos
                                5 - Sair do menu.
                                """, ((Musica) escolha1).getTitulo());
                        escolhaMenuDoObjeto = scanner.nextInt();
                        scanner.nextLine();
                        switch (escolhaMenuDoObjeto) {
                            case 1:
                                ((Musica) escolha1).painelReproducao();

                                break;
                            case 2:
                                ((Musica) escolha1).painelInformacoes();
                                break;
                            case 3:
                                ((Musica) escolha1).sugestoesSemelhantes();
                                break;
                            case 4:
                                if(escolha1.getCurtido()){
                                    escolha1.descurtir();
                                }else {
                                    escolha1.curtir();
                                }
                                break;
                            case 5:
                                System.out.println("Saindo...");
                                j = false; //Quebra do laço
                                break;
                            default:
                                System.out.println("Informe um número válido");
                                break;
                        }
                    }
                    biblioteca.add(escolha1);
                    break;
                case 2:
                    escolha1 = new Podcast();

                    System.out.println("Nome do episódio de podcast: ");
                    pegaTitulo = scanner.nextLine();
                    ((Podcast) escolha1).setTitulo(pegaTitulo);

                    System.out.println("Nome do canal de podcast: ");
                    autoria = scanner.nextLine();
                    ((Podcast) escolha1).setCanal(autoria);

                    System.out.println("Tema (tópico geral) do episódio de podcast: ");
                    String arg1 = scanner.nextLine();
                    ((Podcast) escolha1).setTema(arg1);

                    respostaIf = lerSimOuNao(scanner, "O episódio contém versão em vídeo? (S/N)");
                    if (respostaIf.equalsIgnoreCase("S")) {
                        ((Podcast) escolha1).setContemVideo(true);
                    } else {
                        ((Podcast) escolha1).setContemVideo(false);
                    }

                    System.out.println("Duração do episódio: ");
                    pegaDuracao = scanner.nextDouble();
                    ((Podcast) escolha1).setDuracao(pegaDuracao);
                    scanner.nextLine();

                    System.out.println("Total de reprodução do episódio: ");
                    pegaTotalReproducoes = scanner.nextInt();
                    ((Podcast) escolha1).setTotalReproducoes(pegaTotalReproducoes);
                    scanner.nextLine();

                    System.out.println("Nota do episódio (1-5): ");
                    pegaClassificacao = scanner.nextInt();
                    while (pegaClassificacao > 5 || pegaClassificacao < 0) {
                        System.out.println("Digite uma classificação de 1-5");
                        pegaClassificacao = scanner.nextInt();
                    }
                    ((Podcast) escolha1).setClassificacao(pegaClassificacao);
                    scanner.nextLine();

                    respostaIf = lerSimOuNao(scanner, "É um dos episódios curtidos pelo usuário? ");
                    if (respostaIf.equalsIgnoreCase("S")) {
                        ((Podcast) escolha1).setCurtido(true);
                    } else {
                        ((Podcast) escolha1).setCurtido(false);
                    }

                    System.out.println("Qual o ano de lançamento deste episódio: ");
                    pegaAno = scanner.nextInt();
                    while (pegaAno < 2000 || pegaAno > 2027) {
                        System.out.println("Informe um ano entre 2000-2027");
                        pegaAno = scanner.nextInt();
                    }
                    ((Podcast) escolha1).setAno(pegaAno);
                    scanner.nextLine();

                    ((Painel) escolha1).painelInformacoes();
                    while (j) {
                        System.out.printf("""
                                Menu de %s
                                O que gostaria de fazer?
                                1 - Reproduzir
                                2- Ver informações detalhadas
                                3 - Ver versão em vídeo do Podcast
                                4 - Adicionar/Retirar música de curtidos
                                5 - Sair do menu.
                                """, ((Podcast) escolha1).getTitulo());
                        escolhaMenuDoObjeto = scanner.nextInt();
                        scanner.nextLine();
                        switch (escolhaMenuDoObjeto) {
                            case 1:
                                ((Podcast) escolha1).painelReproducao();
                                break;
                            case 2:
                                ((Podcast) escolha1).painelInformacoes();
                                break;
                            case 3:
                                ((Podcast) escolha1).versaoVideo();
                                break;
                            case 4:
                                if(escolha1.getCurtido()){
                                    escolha1.descurtir();
                                }else {
                                    escolha1.curtir();
                                }
                                break;
                            case 5:
                                System.out.println("Saindo...");
                                j = false;
                                break;
                            default:
                                System.out.println("Informe um número válido");
                                break;
                        }
                    }
                    biblioteca.add(escolha1);
                    break;
                case 3:
                    escolha1 = new Audiolivros();
                    System.out.println("Nome do audioLivro: ");
                    pegaTitulo = scanner.nextLine();
                    ((Audiolivros) escolha1).setTitulo(pegaTitulo);

                    System.out.println("Nome do escritor: ");
                    autoria = scanner.nextLine();
                    ((Audiolivros) escolha1).setAutor(autoria);

                    System.out.println("Quantidade de capítulos: ");
                    int arg2 = scanner.nextInt();
                    ((Audiolivros) escolha1).setCapitulos(arg2);
                    scanner.nextLine();

                    System.out.println("Capitulo atual: ");
                    arg2 = scanner.nextInt();
                    ((Audiolivros) escolha1).setCapituloAtual(arg2);
                    scanner.nextLine();

                    respostaIf = lerSimOuNao(scanner, "O audioLivro participa de alguma coleção? (S/N) ");
                    if (respostaIf.equalsIgnoreCase("S")) {
                        System.out.println("Qual é o nome da coleção? ");
                        respostaIf = scanner.nextLine();
                        ((Audiolivros) escolha1).setColecao(respostaIf);
                    } else {
                        ((Audiolivros) escolha1).setColecao("Conto individual");
                    }

                    System.out.println("Gênero do audioLivro: ");
                    arg1 = scanner.nextLine();
                    ((Audiolivros) escolha1).setGenero(arg1);

                    System.out.println("Duração em minutos: ");
                    pegaDuracao = scanner.nextDouble();
                    ((Audiolivros) escolha1).setDuracao(pegaDuracao);
                    scanner.nextLine();

                    System.out.println("Total de reproduções: ");
                    pegaTotalReproducoes = scanner.nextInt();
                    ((Audiolivros) escolha1).setTotalReproducoes(pegaTotalReproducoes);
                    scanner.nextLine();

                    System.out.println("Nota do audioLivro (1-5): ");
                    pegaClassificacao = scanner.nextInt();
                    while (pegaClassificacao > 5 || pegaClassificacao < 0) {
                        System.out.println("Digite uma classificação de 1-5");
                        pegaClassificacao = scanner.nextInt();
                    }
                    ((Audiolivros) escolha1).setClassificacao(pegaClassificacao);
                    scanner.nextLine();

                    respostaIf = lerSimOuNao(scanner, "É um dos audioLivros curtidos pelo usuário? ");
                    if (respostaIf.equalsIgnoreCase("S")) {
                        ((Audiolivros) escolha1).setCurtido(true);
                    } else {
                        ((Audiolivros) escolha1).setCurtido(false);
                    }

                    System.out.println("Qual o ano de lançamento deste audioLivro: ");
                    pegaAno = scanner.nextInt();
                    while (pegaAno < 1860 || pegaAno > 2027) {
                        System.out.println("Informe um ano entre 1860-2027");
                        pegaAno = scanner.nextInt();
                    }
                    ((Audiolivros) escolha1).setAno(pegaAno);
                    scanner.nextLine();

                    respostaIf = lerSimOuNao(scanner, "O audioLivro é pago (S/N)");
                    if (respostaIf.equalsIgnoreCase("S")) {
                        System.out.println("Informe o preço: ");
                        double arg4 = scanner.nextDouble();
                        while (arg4 <= 0) {
                            System.out.println("Informe um preço maior que 0: ");
                            arg4 = scanner.nextDouble();
                        }
                        ((Audiolivros) escolha1).setPreco(arg4);
                    } else {
                        ((Audiolivros) escolha1).setPreco(0);
                    }

                    ((Painel) escolha1).painelInformacoes();
                    while (j) {
                        System.out.printf("""
                                Menu de %s
                                O que gostaria de fazer?
                                1 - Reproduzir
                                2- Ver informações detalhadas
                                3 - Ver progresso
                                4 - Adicionar/Retirar música de curtidos
                                5 - Sair do menu.
                                """, ((Audiolivros) escolha1).getTitulo());
                        escolhaMenuDoObjeto = scanner.nextInt();
                        scanner.nextLine();
                        switch (escolhaMenuDoObjeto) {
                            case 1:
                                if (((Audiolivros) escolha1).getPreco() > 0) {
                                    System.out.println("O livro custa: R$ " + ((Audiolivros) escolha1).getPreco() + "Gostaria de pagar? (S/N)");
                                    String escolhaUser = scanner.nextLine();
                                    while (!escolhaUser.equalsIgnoreCase("S") && !escolhaUser.equalsIgnoreCase("N")) {
                                        System.out.println("Digite um caractere válido (S/N): S = Sim, N = Não");
                                        escolhaUser = scanner.nextLine();
                                    }//Sistema de acesso por pagamentoo
                                    if (escolhaUser.equalsIgnoreCase("S")) {
                                        ((Audiolivros) escolha1).painelReproducao();
                                    } else {
                                        System.out.println("Acesso restrito. Voltando ao menu...");
                                        break;
                                    }
                                } else {
                                    ((Audiolivros) escolha1).painelReproducao();
                                }

                                break;
                            case 2:
                                ((Audiolivros) escolha1).painelInformacoes();
                                break;
                            case 3:
                                System.out.println(((Audiolivros) escolha1).progresso());
                                break;
                            case 4:
                                if(escolha1.getCurtido()){
                                    escolha1.descurtir();
                                }else {
                                    escolha1.curtir();
                                }
                                break;
                            case 5:
                                System.out.println("Saindo...");
                                j = false;
                                break;
                            default:
                                System.out.println("Informe um número válido");
                                break;
                        }
                    }
                    biblioteca.add(escolha1);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    i = false;
                    break;
                case 5: // Nova opção para listar a biblioteca
                    System.out.println("--- SUA BIBLIOTECA COMPLETA ---");
                    System.out.println("Você tem " + biblioteca.size() + " áudios na biblioteca.\n");
                    if (biblioteca.isEmpty()) {
                        System.out.println("Nenhum item adicionado ainda.");
                    } else {
                        for (Audio audio : biblioteca) {
                            // Graças à Melhoria 4, o println chama automaticamente o toString() de cada objeto!
                            System.out.println(audio);
                            System.out.println("----------------------------------------");
                        }
                    }
                    break;
                default:
                    System.out.println("Informe um número de 1-4");
            }


        }
    }
    private static String lerSimOuNao(Scanner scanner, String mensagem) {
        System.out.println(mensagem);
        String entrada = scanner.nextLine().trim();

        while (!entrada.equalsIgnoreCase("S") && !entrada.equalsIgnoreCase("N")) {
            System.out.println("Digite um caractere válido (S/N): S = Sim, N = Não");
            entrada = scanner.nextLine().trim();
        }

        return entrada;
    }
}
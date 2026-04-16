# projeto-aplicacao-de-audio-poo
Projeto simulador de player de áudio em Java com músicas, podcasts e audiolivros — projeto de conclusão de curso de Java POO da Alura. 
# Sistema de player de Audio: Allan's Music

## Sobre o projeto
Simulador de plataforma de áudio em Java chamada "Allan's Music" que permite a criação e implementação de músicas, podcasts e audiolivros. Além disso, oferece um menu inicial e personalizado para cada tipo de áudio com opções para visualização de informações, reprodução do áudio (simulado), adicionar ou excluir áudio dos favoritos e um método exclusivo para cada tipo: para músicas, encontrar músicas semelhantes (como uma recomendação); para podcast, visualizar versão em vídeo; para audioLivro verificar progresso (ao medir capitulos totais e capitulo atual).

## Tecnologias
- Java
- POO

## Estrutura do projeto
└── br/com/alura/AllansAudio/

├── Audio.java (abstract) ← Superclasse

├── Painel.java (interface) ← Interface

├── Musica.java ← Subclasse

├── Podcast.java ← Subclasse

├── Audiolivros.java ← Subclasse

└── Principal.java ← Executável


## Como executar
1. Baixe os arquivos e abra em uma IDE (Ambiente de desenvolvimento integrado) que permita o uso da a linguagem Java
2. Certifique que o JDK (Kit de desenvolvimento Java) esteja em sua máquina e que tenha o JDK 25
3. Abra o pacote em seu IDE e execute o arquivo 'Principal.java', localizado na pasta 'src'
4. Desfrute do programa :)

## Capacidades do projeto
- Criação de 3 diferentes tipos de objetos
- Escolha de objeto e formulação de seus atributos pelo usuário
- Visualização de atributos, informações e simulação de reprodução
- Métodos exclusivos que simulam capacidades de cada tipo de áudio

## O que aprendi
- Uso de interfaces
- Uso de classes abstratas
- Uso de superclasses e subclasses
- Herança e polimorfismo
- Instanciação de objetos
- Consolidação de laços e estruturas de decisão
  

## Status
Em desenvolvimento — próximas implementações: armazenamento em listas, interface gráfica com Swing

## Autor
Allan Chrystal - GitHub: @allanAcademic

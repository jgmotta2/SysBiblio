package sysbiblio.controller;

import sysbiblio.models.Livro;
import sysbiblio.models.LivroDigital;
import sysbiblio.models.LivroFisico;
import sysbiblio.services.Biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaController {
    private Biblioteca biblio;
    private Scanner lerTeclado = new Scanner(System.in);

    public BibliotecaController() {
        this.biblio = new Biblioteca();
    }

    public void adicionarLivro(Scanner lerTeclado) {
        System.out.println("Digite o título do livro:");
        String titulo = lerTeclado.nextLine();
        System.out.println("Digite o autor do livro:");
        String autor = lerTeclado.nextLine();
        int anoPublicacao = inputNumerico(lerTeclado, "Digite o ano da publicação:");
        int numeroPaginas = inputNumerico(lerTeclado, "Digite o número de páginas:");

        Livro novoLivro;

        int tipoLivro = inputNumerico(lerTeclado, "Qual o tipo do livro: 1-Físico, 2 Digital");
        if (tipoLivro == 1) {
            novoLivro = new LivroFisico();
            System.out.println("Digite as dimensões do livro:");
            String dimensoes = lerTeclado.nextLine();
            int numeroExemplares = inputNumerico(lerTeclado, "Digite o número de exemplares:");

            LivroFisico novoLivroFisico = (LivroFisico) novoLivro;
            novoLivroFisico.setDimensoes(dimensoes);
            novoLivroFisico.setNumeroExemplares(numeroExemplares);
        } else {
            novoLivro = new LivroDigital();
            System.out.println("Digite o formato do arquivo:");
            String formatoArquivo = lerTeclado.nextLine();

            LivroDigital novoLivroDigital = (LivroDigital) novoLivro;
            novoLivroDigital.setFormatoArquivo(formatoArquivo);
        }

        novoLivro.setTitulo(titulo);
        novoLivro.setAutor(autor);
        novoLivro.setAnoPublicacao(anoPublicacao);
        novoLivro.setNumeroPaginas(numeroPaginas);

        try {
            biblio.adicionar(novoLivro);
            System.out.println("\nLivro adicionado com Sucesso!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        System.out.println("\nPress Enter to continue...");
        lerTeclado.nextLine();
    }

    public void pesquisarLivroPorTitulo(Scanner lerTeclado) {
        System.out.println("Digite o título do livro para pesquisar:");
        String titulo = lerTeclado.nextLine();

        List<Livro> livrosEncontrados = biblio.pesquisarPorTitulo(titulo);

        if (livrosEncontrados.isEmpty()) {
            System.out.println("\nNenhum livro encontrado com esse título");
        } else {
            System.out.println("\nLivros encontrados:");
            for (Livro livro : livrosEncontrados) {
                exibirLivroComDetalhes(livro);
            }
        }

        System.out.println("\nPress Enter to continue...");
        lerTeclado.nextLine();
    }

    public void listarTodosLivros() {
        List<Livro> livros = biblio.pesquisarTodos();
        if (livros.isEmpty()) {
            System.out.println("\nNenhum livro cadastrado!");
        } else {
            System.out.println("\nLivros Cadastrados:");
            for (Livro livro : livros) {
                exibirLivroComDetalhes(livro);
            }
        }

        System.out.println("\nPress Enter to continue...");
        lerTeclado.nextLine();
    }

    public void removerLivroPorTitulo(Scanner lerTeclado) {
        System.out.println("Digite o título do livro para remover:");
        String titulo = lerTeclado.nextLine();

        int quantidadeRemovida = biblio.removerPorTitulo(titulo);

        System.out.println("\n" + quantidadeRemovida + " livros foram removidos.");
        System.out.println("\nPress Enter to continue...");
        lerTeclado.nextLine();
    }

    public void ordenarLivrosPorAnoPublicacao() {
        List<Livro> livrosOrdenados = biblio.ordenarPorAnoPublicacao();

        if (livrosOrdenados.isEmpty()) {
            System.out.println("\nNenhum livro cadastrado!");
        } else {
            System.out.println("\nLivros Ordenados do mais antigo ao mais novo:");
            for (Livro livro : livrosOrdenados) {
                exibirLivroComDetalhes(livro);
            }
        }
        System.out.println("\nPress Enter to continue...");
        lerTeclado.nextLine();
    }

    public void pesquisarLivroPorAutor(Scanner lerTeclado) {
        System.out.println("Digite o nome do autor para pesquisar:");
        String autor = lerTeclado.nextLine();

        List<Livro> livrosEncontrados = biblio.pesquisarPorAutor(autor);

        if (livrosEncontrados.isEmpty()) {
            System.out.println("\nNenhum livro encontrado desse autor");
        } else {
            System.out.println("\nLivros encontrados do autor " + autor + ":");
            for (Livro livro : livrosEncontrados) {
                exibirLivroComDetalhes(livro);
            }
        }
        System.out.println("\nPress Enter to continue...");
        lerTeclado.nextLine();
    }

    private void exibirLivroComDetalhes(Livro livro) {
        System.out.println(livro.toString() +
                " - Formato: " + livro.getFormato() +
                " - Tempo de publicação: " + livro.calcularTempoPublicacao() + " anos");
    }

    private int inputNumerico(Scanner lerTeclado, String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.println(mensagem);
        do {
            String valorStr = lerTeclado.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("\nErro. Por favor informe um número Inteiro");
            }
        } while (!entradaValida);
        return valor;
    }
}

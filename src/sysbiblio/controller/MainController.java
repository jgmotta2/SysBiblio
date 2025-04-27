package sysbiblio.controller;

import java.util.Scanner;

public class MainController {
    private BibliotecaController bibliotecaController;
    private Scanner lerTeclado;

    public MainController() {
        this.bibliotecaController = new BibliotecaController();
        this.lerTeclado = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        String menu = """
                ====== SYSBIBLIO ======
                Escolha uma das opções abaixo:
                1 - Adicionar novo livro
                2 - Pesquisar livro por título
                3 - Listar todos os livros
                4 - Remover livro por título
                5 - Ordenar os livros pelo ano de publicação (do mais antigo ao mais novo)
                6 - Pesquisar por autor
                0 - Sair
                
                Digite a opção desejada:""";
        int opcao;
        do {
            opcao = inputNumerico(menu);
            switch (opcao) {
                case 1:
                    bibliotecaController.adicionarLivro(lerTeclado);
                    break;
                case 2:
                    bibliotecaController.pesquisarLivroPorTitulo(lerTeclado);
                    break;
                case 3:
                    bibliotecaController.listarTodosLivros();
                    break;
                case 4:
                    bibliotecaController.removerLivroPorTitulo(lerTeclado);
                    break;
                case 5:
                    bibliotecaController.ordenarLivrosPorAnoPublicacao();
                    break;
                case 6:
                    bibliotecaController.pesquisarLivroPorAutor(lerTeclado);
                    break;
                case 0:
                    System.out.println("Encerrando programa ...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);

        lerTeclado.close();
    }

    private int inputNumerico(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.println(mensagem);
        do {
            String valorStr = lerTeclado.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Erro. Por favor informe um número Inteiro");
            }
        } while (!entradaValida);
        return valor;
    }
}

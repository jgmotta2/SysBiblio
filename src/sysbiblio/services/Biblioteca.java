package sysbiblio.services;

import sysbiblio.models.Livro;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> acervo = new ArrayList<>();

    public void adicionar(Livro novoLivro) throws Exception {
        if (novoLivro.getTitulo() == null || novoLivro.getTitulo().trim().isEmpty())
            throw new Exception("Título não pode estar em branco!");

        if (novoLivro.getAutor() == null || novoLivro.getAutor().trim().isEmpty())
            throw new Exception("Autor não pode estar em branco!");

        final int ANO_PUBLICACAO_MINIMO = 1400;
        if (novoLivro.getAnoPublicacao() < ANO_PUBLICACAO_MINIMO)
            throw new Exception("Ano de publicação não pode ser menor que " + ANO_PUBLICACAO_MINIMO + "!");

        if (novoLivro.getNumeroPaginas() <= 0)
            throw new Exception("Número de páginas não pode ser zero ou negativo!");

        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(novoLivro.getTitulo())) {
                throw new Exception("Já existe um livro com este título na biblioteca!");
            }
        }

        acervo.add(novoLivro);

    }

    public List<Livro> pesquisarPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisarTodos() {
        return acervo;
    }

    public int removerPorTitulo(String titulo) {
        int removidos = 0;
        List<Livro> livrosParaRemover = new ArrayList<>();

        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosParaRemover.add(livro);
                removidos++;
            }
        }

        acervo.removeAll(livrosParaRemover);
        return removidos;
    }

    public List<Livro> ordenarPorAnoPublicacao() {
        List<Livro> livrosOrdenados = new ArrayList<>(acervo);

        for (int i = 0; i < livrosOrdenados.size() - 1; i++) {
            for (int j = 0; j < livrosOrdenados.size() - i - 1; j++) {
                if (livrosOrdenados.get(j).getAnoPublicacao() > livrosOrdenados.get(j + 1).getAnoPublicacao()) {
                    Livro temp = livrosOrdenados.get(j);
                    livrosOrdenados.set(j, livrosOrdenados.get(j + 1));
                    livrosOrdenados.set(j + 1, temp);
                }
            }
        }

        return livrosOrdenados;
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }
}

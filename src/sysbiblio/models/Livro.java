package sysbiblio.models;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numeroPaginas;

    @Override
    public String toString() {
        String descricao =
                "Título: " + getTitulo() +
                        " - Autor: " + getAutor() +
                        " - Ano: " + getAnoPublicacao();
        return descricao;
    }

    public String getFormato() {
        return "Livro";
    }

    public int calcularTempoPublicacao() {
        int anoAtual = 2025;
        return anoAtual - getAnoPublicacao();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }


}

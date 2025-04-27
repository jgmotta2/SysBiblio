package sysbiblio.models;

public class LivroFisico extends Livro {
    private int numeroExemplares;
    private String dimensoes;

    @Override
    public String toString() {
        String descricao = super.toString();
        descricao += " - Exemplares:" + getNumeroExemplares();
        return descricao;
    }

    @Override
    public String getFormato() {
        return "Livro Físico";
    }

    public int getNumeroExemplares() {return numeroExemplares;}

    public void setNumeroExemplares(int numeroExemplares) {this.numeroExemplares = numeroExemplares;}

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }
}

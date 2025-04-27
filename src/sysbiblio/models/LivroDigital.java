package sysbiblio.models;

public class LivroDigital extends Livro {
    private String formatoArquivo;

    @Override
    public String toString() {
        String descricao = super.toString();
        descricao += " - Formato:" + getFormatoArquivo();
        return descricao;
    }

    @Override
    public String getFormato() {
        return "Livro Digital";
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

}

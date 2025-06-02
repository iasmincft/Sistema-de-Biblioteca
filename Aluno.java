public class Aluno extends Usuario {
    private int creditos;

    public Aluno(int id, String nome, int creditos) {
        super(id, nome);
        this.creditos = creditos;
    }

    @Override
    public boolean podeEmprestar() {
        return creditos > 0;
    }
    public void debitarCredito() {
        if (creditos > 0) {
            creditos--;
        } else {
            throw new IllegalStateException("Não há créditos suficientes para debitar.");
        }
    }
    public void adicionarCredito(int valor) {
        if (valor > 0) {
            creditos += valor;
        } else {
            throw new IllegalArgumentException("Valor de crédito deve ser positivo.");
        }
    }
    public int getCreditos() {
        return creditos;
    }

}

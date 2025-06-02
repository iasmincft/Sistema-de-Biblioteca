public class DevolverLivroUseCase {
    public void executar(Usuario usuario, Livro livro) {
        if (!usuario.equals(livro.getEmprestadoPara())) {
            System.out.println("Este livro não foi emprestado para este usuário.");
            return;
        }

        if (usuario instanceof Aluno aluno) {
            aluno.adicionarCredito(1);
        }

        livro.setDisponivel(true);
        livro.setEmprestadoPara(null);
        System.out.println("Livro devolvido com sucesso.");
    }
}

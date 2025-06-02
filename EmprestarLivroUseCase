public class EmprestarLivroUseCasee {
    public void executar(Usuario usuario, Livro livro) {
        if (!livro.isDisponivel()) {
            System.out.println("Livro não está disponível.");
            return;
        }

        if (!usuario.podeEmprestar()) {
            System.out.println("Usuário não pode emprestar livros.");
            return;
        }

        if (usuario instanceof Aluno aluno) {
            aluno.debitarCredito();
        }

        livro.setDisponivel(false);
        livro.setEmprestadoPara(usuario);
        System.out.println("Livro emprestado com sucesso.");
    }
}

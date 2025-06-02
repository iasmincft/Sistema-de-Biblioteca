import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        EmprestarLivroUseCasee emprestar = new EmprestarLivroUseCasee();
        DevolverLivroUseCase devolver = new DevolverLivroUseCase();

        // Adicionando alguns livros iniciais
        Livro l1 = new Livro(1, "Java Básico", 1);
        Livro l2 = new Livro(2, "Estrutura de Dados", 1);
        biblioteca.adicionarLivro(l1);
        biblioteca.adicionarLivro(l2);

        // Criando alguns usuários
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno(1, "Ana", 2));
        alunos.add(new Aluno(2, "João", 3));
        alunos.add(new Aluno(3, "Maria", 1));
        
        Professor prof = new Professor(2, "Carlos");

        while (true) {
            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1. Listar livros disponíveis");
            System.out.println("2. Emprestar livro");
            System.out.println("3. Devolver livro");
            System.out.println("4. Ver créditos do aluno");
            System.out.println("5. Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("\nLivros disponíveis:");
                    biblioteca.listarLivrosDisponiveis().forEach(l -> 
                        System.out.println("- " + l.getTitulo() + " (ID: " + l.getId() + ")"));
                    break;

                case 2:
                    System.out.println("\nEscolha o tipo de usuário:");
                    System.out.println("1. Aluno");
                    System.out.println("2. Professor");
                    int tipoUsuario = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.print("Digite o ID do livro: ");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    Livro livroEmprestimo = biblioteca.buscarLivroPorId(idLivro);
                    if (livroEmprestimo != null) {
                        if (tipoUsuario == 1) {
                            System.out.print("Digite o ID do aluno: ");
                            int idAluno = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer
                            Aluno alunoEmprestimo = alunos.stream()
                                .filter(a -> a.getId() == idAluno)
                                .findFirst()
                                .orElse(null);
                            if (alunoEmprestimo != null) {
                                emprestar.executar(alunoEmprestimo, livroEmprestimo);
                            } else {
                                System.out.println("Aluno não encontrado!");
                            }
                        } else {
                            emprestar.executar(prof, livroEmprestimo);
                        }
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                case 3:
                    System.out.println("\nEscolha o tipo de usuário:");
                    System.out.println("1. Aluno");
                    System.out.println("2. Professor");
                    tipoUsuario = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.print("Digite o ID do livro: ");
                    idLivro = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    Livro livroDevolucao = biblioteca.buscarLivroPorId(idLivro);
                    if (livroDevolucao != null) {
                        if (tipoUsuario == 1) {
                            System.out.print("Digite o ID do aluno: ");
                            int idAluno = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer
                            Aluno alunoDevolucao = alunos.stream()
                                .filter(a -> a.getId() == idAluno)
                                .findFirst()
                                .orElse(null);
                            if (alunoDevolucao != null) {
                                devolver.executar(alunoDevolucao, livroDevolucao);
                            } else {
                                System.out.println("Aluno não encontrado!");
                            }
                        } else {
                            devolver.executar(prof, livroDevolucao);
                        }
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                case 4:
                    System.out.println("\nAlunos cadastrados:");
                    alunos.forEach(a -> System.out.println("- " + a.getNome() + " (ID: " + a.getId() + ")"));
                    System.out.print("\nDigite o ID do aluno para ver os créditos: ");
                    int idAlunoConsulta = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    
                    Aluno alunoConsulta = alunos.stream()
                        .filter(a -> a.getId() == idAlunoConsulta)
                        .findFirst()
                        .orElse(null);
                        
                    if (alunoConsulta != null) {
                        System.out.println("\nCréditos do aluno " + alunoConsulta.getNome() + ": " + alunoConsulta.getCreditos());
                    } else {
                        System.out.println("Aluno não encontrado!");
                    }
                    break;

                case 5:
                    System.out.println("\nObrigado por usar o sistema!");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nOpção inválida!");
            }
        }
    }
}

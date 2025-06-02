# Sistema de Biblioteca

Este é um sistema de biblioteca que permite o gerenciamento de empréstimos e devoluções de livros, com regras específicas para alunos e professores.

## Funcionalidades

- Empréstimo de livros
- Devolução de livros
- Sistema de créditos para alunos
- Empréstimo livre para professores
- Listagem de livros disponíveis

## Requisitos

- Java JDK 11 ou superior
- Terminal ou prompt de comando

## Como Executar

### Via Linha de Comando

1. Abra o terminal/prompt de comando
2. Navegue até a pasta do projeto
3. Compile todos os arquivos Java:
      javac *.java

4. Execute o programa:
      java Main

## Como Usar o Sistema

Ao iniciar o programa, você verá um menu com as seguintes opções:

1. **Listar livros disponíveis**
   - Mostra todos os livros que podem ser emprestados

2. **Emprestar livro**
   - Escolha entre aluno ou professor
   - Digite o ID do livro
   - Se for aluno, digite o ID do aluno
   - O sistema verifica se o aluno tem créditos suficientes

3. **Devolver livro**
   - Escolha entre aluno ou professor
   - Digite o ID do livro
   - Se for aluno, digite o ID do aluno
   - Alunos ganham 1 crédito ao devolver

4. **Ver créditos do aluno**
   - Lista todos os alunos cadastrados
   - Digite o ID do aluno para ver seus créditos

5. **Sair**
   - Encerra o programa

## Dados Iniciais

O sistema já vem com alguns dados cadastrados:

### Livros
- ID 1: Java Básico
- ID 2: Estrutura de Dados

### Alunos
- ID 1: Ana (2 créditos)
- ID 2: João (3 créditos)
- ID 3: Maria (1 crédito)

### Professor
- ID 2: Carlos (empréstimo livre)

## Observações

- Alunos precisam ter créditos para emprestar livros
- Professores podem emprestar livros livremente
- Ao devolver um livro, alunos ganham 1 crédito
- O sistema valida todas as operações antes de executá-las 

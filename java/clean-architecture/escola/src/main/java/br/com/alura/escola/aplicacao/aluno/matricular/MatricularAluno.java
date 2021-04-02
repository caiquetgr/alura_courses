package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.RepositoryDeAlunos;

public class MatricularAluno {

    private final RepositoryDeAlunos repositoryDeAlunos;

    public MatricularAluno(RepositoryDeAlunos repositoryDeAlunos) {
        this.repositoryDeAlunos = repositoryDeAlunos;
    }

    public void matricular(MatricularAlunoDto dadosMatricula) {
        repositoryDeAlunos.matricular(dadosMatricula.criarAluno());
    }
}

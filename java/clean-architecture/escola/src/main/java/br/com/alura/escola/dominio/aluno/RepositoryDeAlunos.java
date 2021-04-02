package br.com.alura.escola.dominio.aluno;

public interface RepositoryDeAlunos {

    void matricular(Aluno aluno);

    Aluno buscarPorCof(CPF cpf);

}

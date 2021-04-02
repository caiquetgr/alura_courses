package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosInMemory;

public class MatricularAlunoTeste {

    public static void main(String[] args) {
        final String nome = "Fulano";
        final String cpf =  "123.456.789-00";
        final String email = "fulano@gmail.com";

        final MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosInMemory());
        matricularAluno.matricular(new MatricularAlunoDto(nome, cpf, email));
    }

}

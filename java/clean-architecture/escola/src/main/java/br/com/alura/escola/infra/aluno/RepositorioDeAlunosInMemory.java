package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.RepositoryDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosInMemory implements RepositoryDeAlunos {

    private static List<Aluno> alunos = new ArrayList<Aluno>();

    @Override
    public void matricular(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public Aluno buscarPorCof(CPF cpf) {
        final String numeroCpf = cpf.getNumero();
        return alunos.stream()
                .filter(a -> a.getNumeroCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }
}

package br.com.alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAO {

    private static final List<Aluno> alunos = new ArrayList<>();

    public static void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public static List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}

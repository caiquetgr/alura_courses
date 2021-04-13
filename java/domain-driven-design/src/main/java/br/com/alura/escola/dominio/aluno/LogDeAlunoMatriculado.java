package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.Evento;
import br.com.alura.escola.dominio.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {

    public void reageAo(AlunoMatriculado alunoMatriculado) {
        final String momentoFormatado = alunoMatriculado.getMomento().format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(String.format("Aluno com CPF %s matriculado em: %s",
                alunoMatriculado.getCpfDoAluno(),
                momentoFormatado));
    }

    @Override
    protected void reageAo(Evento evento) {
        reageAo((AlunoMatriculado) evento);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}

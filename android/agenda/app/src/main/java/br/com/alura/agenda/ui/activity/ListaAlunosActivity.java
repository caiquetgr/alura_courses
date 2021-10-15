package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.com.alura.R;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle("Lista de alunos");

        FloatingActionButton fabNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);

        fabNovoAluno.setOnClickListener(view -> {
            irParaFormularioAluno();
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        List<Aluno> alunos = AlunoDAO.todos();

        ArrayAdapter<Aluno> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos);
        listaDeAlunos.setAdapter(adapter);
    }

    private void irParaFormularioAluno() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

}

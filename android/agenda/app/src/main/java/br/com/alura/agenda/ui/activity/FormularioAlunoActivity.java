package br.com.alura.agenda.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.R;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Novo aluno");
        setContentView(R.layout.activity_formulario_aluno);

        final EditText nome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText telefone = findViewById(R.id.activity_formulario_aluno_telefone);
        final EditText email = findViewById(R.id.activity_formulario_aluno_email);

        final Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        botaoSalvar.setOnClickListener(view -> {
            AlunoDAO.salvar(criarAluno(nome, telefone, email));
            finish();
        });
    }

    private Aluno criarAluno(EditText nome, EditText telefone, EditText email) {
        return new Aluno(
                nome.getText().toString(),
                telefone.getText().toString(),
                email.getText().toString());
    }

}
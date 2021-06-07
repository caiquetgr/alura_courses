package br.com.alura.rh.model;

import java.math.BigDecimal;

// efeito colateral de que um terceirizado tem métodos como promover e atualizarSalario
public class Terceirizado extends Funcionario {

    private String empresa;

    public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario) {
        super(nome, cpf, cargo, salario);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

}

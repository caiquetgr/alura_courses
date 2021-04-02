package br.com.alura.escola.dominio.aluno;

/**
 * Entidades: possuem uma identidade única, como por exemplo um Aluno tem um CPF único
 * Value object: classe que é distinguida por todos seus atributos. Um telefone que todos os atributos são iguais,
 * consideramos como o mesmo telefone
 */
public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }
}

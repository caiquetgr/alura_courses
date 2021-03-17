package escola;

public class Email {

    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^(.+)@(.+)$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.endereco = endereco;
    }
}

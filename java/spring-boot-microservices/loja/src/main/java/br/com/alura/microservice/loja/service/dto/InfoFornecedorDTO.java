package br.com.alura.microservice.loja.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class InfoFornecedorDTO {
    private Long id;
    private String nome;
    private String estado;
    private String endereco;
}

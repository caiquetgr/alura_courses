package br.com.alura.microservice.loja.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {

    private List<ItemCompraDTO> itens;
    private EnderecoDTO endereco;

}

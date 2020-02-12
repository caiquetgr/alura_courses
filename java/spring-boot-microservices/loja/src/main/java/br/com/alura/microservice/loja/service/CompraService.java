package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.service.dto.InfoFornecedorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final FornecedorClient fornecedorClient;

    public void processarCompra(CompraDTO compraDTO) {

        InfoFornecedorDTO infoFornecedorDTO = fornecedorClient.buscarInfoPorEstado(compraDTO.getEndereco().getEstado());

        System.out.println(infoFornecedorDTO);

    }

}

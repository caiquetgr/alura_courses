package br.com.alura.microservice.loja.client;

import br.com.alura.microservice.loja.service.dto.InfoFornecedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @GetMapping("/info/{estado}")
    InfoFornecedorDTO buscarInfoPorEstado(@PathVariable String estado);

}

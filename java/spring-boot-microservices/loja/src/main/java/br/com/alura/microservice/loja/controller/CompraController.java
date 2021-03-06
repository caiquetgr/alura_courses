package br.com.alura.microservice.loja.controller;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comprar")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public void comprar(@RequestBody CompraDTO compraDTO) {
        compraService.processarCompra(compraDTO);
    }

}

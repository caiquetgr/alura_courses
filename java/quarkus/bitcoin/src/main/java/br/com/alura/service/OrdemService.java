package br.com.alura.service;

import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.time.LocalDate;

@ApplicationScoped
public class OrdemService {

    @Inject
    private OrdemRepository ordemRepository;

    public void inserir(SecurityContext securityContext, Ordem ordem) {

        final Usuario usuario = Usuario.<Usuario>findByIdOptional(ordem.getUserId())
                .orElseThrow();

        validateUser(usuario, securityContext.getUserPrincipal());

        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }

    private void validateUser(Usuario usuario, Principal userPrincipal) {

        if (!userPrincipal.getName().equals(usuario.getUsername())) {
            throw new RuntimeException("O usuário logado é diferente do enviado");
        }

    }

}

package br.com.alura.resource;

import br.com.alura.model.Ordem;
import br.com.alura.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/ordens")
public class OrdemResource {

    @Inject
    private OrdemService ordemService;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public void inserir(@Context SecurityContext securityContext, Ordem ordem) {
        ordemService.inserir(securityContext, ordem);
    }

}

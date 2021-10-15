package br.com.alura.resource;

import br.com.alura.model.Bitcoin;
import br.com.alura.service.BitcoinService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bitcoins")
public class BitcoinResource {

    @Inject
    @RestClient
    private BitcoinService bitcoinService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listar() {
        return bitcoinService.listar();
    }

}

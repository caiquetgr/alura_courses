package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;
    private List<Lance> lances;
    private Exception exceptionThrown;

    @Before
    public void setup() {
        this.lances = new ArrayList<>();
        this.leilao = new Leilao("Table XPTO");
    }

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("fulano");
        lance = new Lance(usuario, BigDecimal.TEN);
    }

    @Quando("propoe um lance ao leilao")
    public void propoe_um_lance_ao_leilao() {
        leilao.propoe(lance);
    }

    @Entao("o lance eh aceito")
    public void entao_o_lance_eh_aceito() {
        assertEquals(1, leilao.getLances().size());
        assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }

    @Dado("um lance de {double} reais do usuario {string}")
    public void varios_lances_validos(Double valor, String nomeUsuario) {
        lances.add(new Lance(new Usuario(nomeUsuario), BigDecimal.valueOf(valor)));
    }

    @Quando("propoe varios lances ao leilao")
    public void propoe_varios_lances_ao_leilao() {
        lances.forEach(leilao::propoe);
    }

    @Entao("os lances sao aceitos")
    public void os_lances_sao_aceitos() {

        assertEquals(lances.size(), leilao.getLances().size());

        for (int i = 0; i < lances.size(); i++) {
            assertEquals(lances.get(i).getValor(), leilao.getLances().get(i).getValor());
        }

    }

    @Dado("um lance inválido de {double} reais do usuário {string}")
    public void um_lance_invalido_de_reais(Double valor, String nomeUsuario) {
        this.lance = new Lance(new Usuario(nomeUsuario), BigDecimal.valueOf(valor));
    }

    @Entao("o lance nao eh aceito")
    public void o_lance_nao_eh_aceito() {
        assertEquals(0, leilao.getLances().size());
    }

    @Dado("dois lances")
    public void dois_lances(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps();

        maps.forEach(mapa -> {
            lances.add(new Lance(new Usuario(mapa.get("nomeUsuario")),
                    BigDecimal.valueOf(Double.valueOf(mapa.get("valor")))));
        });

    }

    @Entao("o segundo lance não é aceitos")
    public void o_segundo_lance_nao_e_aceitos() {
        assertEquals(1, leilao.getLances().size());
        assertEquals(lances.get(0).getValor(), leilao.getLances().get(0).getValor());
    }

}

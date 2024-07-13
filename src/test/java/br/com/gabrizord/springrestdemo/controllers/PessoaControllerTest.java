package br.com.gabrizord.springrestdemo.controllers;

import br.com.gabrizord.springrestdemo.entities.PessoaFisica;
import br.com.gabrizord.springrestdemo.services.PessoaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;

@WebMvcTest(controllers = PessoaController.class)
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PessoaService pessoaService;

    @Test
    public void getPessoaById_whenPessoaExists_returnPessoa() throws Exception {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setId(1L);
        pessoaFisica.setNome("Gabriel");
        pessoaFisica.setEndereco("Rua dos Bobos, 0");
        pessoaFisica.setEmail("gabriel@me.com");
        pessoaFisica.setTelefone("123456789");
        pessoaFisica.setCpf("12345678901");
        pessoaFisica.setRg("123456789");

        given(pessoaService.findById(1L)).willReturn(pessoaFisica);
    }
}
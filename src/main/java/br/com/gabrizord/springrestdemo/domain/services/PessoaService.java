package br.com.gabrizord.springrestdemo.domain.services;

import br.com.gabrizord.springrestdemo.api.converter.PessoaConverter;
import br.com.gabrizord.springrestdemo.domain.entities.Pessoa;
import br.com.gabrizord.springrestdemo.api.dto.PessoaDTO;
import br.com.gabrizord.springrestdemo.domain.entities.PessoaFisica;
import br.com.gabrizord.springrestdemo.domain.entities.PessoaJuridica;
import br.com.gabrizord.springrestdemo.domain.repositories.PessoaFisicaRepository;
import br.com.gabrizord.springrestdemo.domain.repositories.PessoaJuridicaRepository;
import br.com.gabrizord.springrestdemo.domain.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class PessoaService {

    private final PessoaFisicaRepository pessoaFisicaRepository;

    private final PessoaJuridicaRepository pessoaJuridicaRepository;

    private final PessoaRepository pessoaRepository;


    @Autowired
    public PessoaService(PessoaFisicaRepository pessoaFisicaRepository, PessoaJuridicaRepository pessoaJuridicaRepository, PessoaRepository pessoaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.addAll(pessoaFisicaRepository.findAll());
        pessoas.addAll(pessoaJuridicaRepository.findAll());
        return pessoas;
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa not found with ID: " + id));
    }

    public Pessoa save(Pessoa pessoa) {
        checkUnique(pessoa);
        if (pessoa instanceof PessoaFisica pessoaFisica) {
            return pessoaFisicaRepository.save(pessoaFisica);
        }
        return pessoaJuridicaRepository.save((PessoaJuridica) pessoa);
    }

    private void checkUnique(Pessoa pessoa) {
        if (pessoa instanceof PessoaFisica pf) {
            pessoaFisicaRepository.findByCpf(pf.getCpf())
                    .ifPresent(p -> {
                        throw new IllegalArgumentException("CPF já registrado: " + pf.getCpf());
                    });
        } else if (pessoa instanceof PessoaJuridica pj) {
            pessoaJuridicaRepository.findByCnpj(pj.getCnpj())
                    .ifPresent(p -> {
                        throw new IllegalArgumentException("CNPJ já registrado: " + pj.getCnpj());
                    });
        }
        pessoaRepository.findByEmail(pessoa.getEmail())
                .ifPresent(p -> {
                    throw new IllegalArgumentException("E-mail já registrado: " + pessoa.getEmail());
                });
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa convertToEntity(PessoaDTO pessoaDTO) {
        return PessoaConverter.toEntity(pessoaDTO);
    }

    public Pessoa update(Pessoa pessoa, Map<String, Object> updates) {
        pessoa.setNome(Objects.toString(updates.getOrDefault("nome", pessoa.getNome())));
        pessoa.setEmail(Objects.toString(updates.getOrDefault("email", pessoa.getEmail())));
        pessoa.setEndereco(Objects.toString(updates.getOrDefault("endereco", pessoa.getEndereco())));
        pessoa.setTelefone(Objects.toString(updates.getOrDefault("telefone", pessoa.getTelefone())));

        if (pessoa instanceof PessoaFisica pessoaFisica) {
            pessoaFisica.setCpf(Objects.toString(updates.getOrDefault("cpf", pessoaFisica.getCpf())));
            pessoaFisica.setRg(Objects.toString(updates.getOrDefault("rg", pessoaFisica.getRg())));
        } else if (pessoa instanceof PessoaJuridica pessoaJuridica) {
            pessoaJuridica.setCnpj(Objects.toString(updates.getOrDefault("cnpj", pessoaJuridica.getCnpj())));
            pessoaJuridica.setInscricaoEstadual(Objects.toString(updates.getOrDefault("inscricaoEstadual", pessoaJuridica.getInscricaoEstadual())));
            pessoaJuridica.setInscricaoMunicipal(Objects.toString(updates.getOrDefault("inscricaoMunicipal", pessoaJuridica.getInscricaoMunicipal())));
            pessoaJuridica.setPais(Objects.toString(updates.getOrDefault("pais", pessoaJuridica.getPais())));
            pessoaJuridica.setRegimeTributario(Objects.toString(updates.getOrDefault("regimeTributario", pessoaJuridica.getRegimeTributario())));
            pessoaJuridica.setNaturezaJuridica(Objects.toString(updates.getOrDefault("naturezaJuridica", pessoaJuridica.getNaturezaJuridica())));
            pessoaJuridica.setCodigoAtividade(Objects.toString(updates.getOrDefault("codigoAtividade", pessoaJuridica.getCodigoAtividade())));
            pessoaJuridica.setResponsavel(Objects.toString(updates.getOrDefault("responsavel", pessoaJuridica.getResponsavel())));
            pessoaJuridica.setCpfResponsavel(Objects.toString(updates.getOrDefault("cpfResponsavel", pessoaJuridica.getCpfResponsavel())));
            pessoaJuridica.setSituacaoCadastral(Objects.toString(updates.getOrDefault("situacaoCadastral", pessoaJuridica.getSituacaoCadastral())));
        }
        return pessoaRepository.save(pessoa);
    }
}

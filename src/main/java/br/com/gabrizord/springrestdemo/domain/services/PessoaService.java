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
        if (pessoa instanceof PessoaFisica) {
            return pessoaFisicaRepository.save((PessoaFisica) pessoa);
        } else if (pessoa instanceof PessoaJuridica) {
            return pessoaJuridicaRepository.save((PessoaJuridica) pessoa);
        } else {
            throw new IllegalArgumentException("Tipo de pessoa inválido.");
        }
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
}

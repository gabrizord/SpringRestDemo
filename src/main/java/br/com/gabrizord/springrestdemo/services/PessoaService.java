package br.com.gabrizord.springrestdemo.services;

import br.com.gabrizord.springrestdemo.entities.Pessoa;
import br.com.gabrizord.springrestdemo.dtos.PessoaDTO;
import br.com.gabrizord.springrestdemo.entities.PessoaFisica;
import br.com.gabrizord.springrestdemo.entities.PessoaJuridica;
import br.com.gabrizord.springrestdemo.repositories.PessoaFisicaRepository;
import br.com.gabrizord.springrestdemo.repositories.PessoaJuridicaRepository;
import br.com.gabrizord.springrestdemo.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if (pessoa instanceof PessoaFisica pf) {
            pessoaFisicaRepository.findByCpf(pf.getCpf())
                    .ifPresent(p -> {
                        throw new IllegalArgumentException("CPF já registrado: " + pf.getCpf());
                    });
            return pessoaFisicaRepository.save(pf);
        } else if (pessoa instanceof PessoaJuridica pj) {
            pessoaJuridicaRepository.findByCnpj(pj.getCnpj())
                    .ifPresent(p -> {
                        throw new IllegalArgumentException("CNPJ já registrado: " + pj.getCnpj());
                    });
            return pessoaJuridicaRepository.save(pj);
        }
        throw new IllegalArgumentException("Tipo de pessoa inválido.");
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa convertToEntity(PessoaDTO pessoaDTO) {
        return pessoaDTO.toEntity();
    }

}

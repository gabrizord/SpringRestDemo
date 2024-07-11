package br.com.gabrizord.springrestdemo.services;

import br.com.gabrizord.springrestdemo.entities.Pessoa;
import br.com.gabrizord.springrestdemo.dtos.PessoaDTO;
import br.com.gabrizord.springrestdemo.entities.PessoaFisica;
import br.com.gabrizord.springrestdemo.entities.PessoaJuridica;
import br.com.gabrizord.springrestdemo.repositories.PessoaFisicaRepository;
import br.com.gabrizord.springrestdemo.repositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaFisicaRepository pessoaFisicaRepository;

    private final PessoaJuridicaRepository pessoaJuridicaRepository;


    @Autowired
    public PessoaService(PessoaFisicaRepository pessoaFisicaRepository, PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }


    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.addAll(pessoaFisicaRepository.findAll());
        pessoas.addAll(pessoaJuridicaRepository.findAll());
        return pessoas;
    }

    public Optional<Pessoa> findById(Long id) {
        Optional<Pessoa> pessoa = pessoaFisicaRepository.findById(id)
                .map(pf -> pf);
        if (pessoa.isEmpty()) {
            pessoa = pessoaJuridicaRepository.findById(id)
                    .map(pj -> pj);
        }
        return Optional.of(pessoa.orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada: " + id)));
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
        pessoaFisicaRepository.deleteById(id);
        pessoaJuridicaRepository.deleteById(id);
    }

    public Pessoa convertToEntity(PessoaDTO pessoaDTO) {
        return pessoaDTO.toEntity();
    }

}

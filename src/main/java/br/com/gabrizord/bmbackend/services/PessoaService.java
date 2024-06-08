package br.com.gabrizord.bmbackend.services;

import br.com.gabrizord.bmbackend.entities.Pessoa;
import br.com.gabrizord.bmbackend.entities.PessoaDTO;
import br.com.gabrizord.bmbackend.entities.PessoaFisica;
import br.com.gabrizord.bmbackend.entities.PessoaJuridica;
import br.com.gabrizord.bmbackend.repositories.PessoaFisicaRepository;
import br.com.gabrizord.bmbackend.repositories.PessoaJuridicaRepository;
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
        Optional<Pessoa> pessoa = pessoaFisicaRepository.findById(id).map(p -> p);
        if (pessoa.isEmpty()) {
            pessoa = pessoaJuridicaRepository.findById(id).map(p -> p);
        }
        return pessoa;
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
        if ("F".equals(pessoaDTO.getTipoPessoa())) {
            return new PessoaFisica(pessoaDTO.getNome(), pessoaDTO.getEndereco(), pessoaDTO.getEmail(), pessoaDTO.getTelefone(),
                    pessoaDTO.getCpf(), pessoaDTO.getRg());
        } else if ("J".equals(pessoaDTO.getTipoPessoa())) {
            return new PessoaJuridica(pessoaDTO.getNome(), pessoaDTO.getEndereco(), pessoaDTO.getEmail(), pessoaDTO.getTelefone(),
                    pessoaDTO.getCnpj(), pessoaDTO.getInscricaoEstadual(), pessoaDTO.getInscricaoMunicipal(), pessoaDTO.getPais(),
                    pessoaDTO.getRegimeTributario(), pessoaDTO.getNaturezaJuridica(), pessoaDTO.getCodigoAtividade(),
                    pessoaDTO.getResponsavel(), pessoaDTO.getCpfResponsavel(), pessoaDTO.getSituacaoCadastral());
        }
        throw new IllegalArgumentException("Tipo de pessoa inválido: " + pessoaDTO.getTipoPessoa());
    }
}

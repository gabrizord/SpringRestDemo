package br.com.gabrizord.bmbackend.services;

import br.com.gabrizord.bmbackend.dtos.PessoaFisicaDTO;
import br.com.gabrizord.bmbackend.dtos.PessoaJuridicaDTO;
import br.com.gabrizord.bmbackend.entities.Pessoa;
import br.com.gabrizord.bmbackend.dtos.PessoaDTO;
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
        if (pessoaDTO instanceof PessoaFisicaDTO pfDTO) {
            return new PessoaFisica(
                    pfDTO.getNome(),
                    pfDTO.getEndereco(),
                    pfDTO.getEmail(),
                    pfDTO.getTelefone(),
                    pfDTO.getCpf(),
                    pfDTO.getRg()
            );
        } else if (pessoaDTO instanceof PessoaJuridicaDTO pjDTO) {
            return new PessoaJuridica(
                    pjDTO.getNome(),
                    pjDTO.getEndereco(),
                    pjDTO.getEmail(),
                    pjDTO.getTelefone(),
                    pjDTO.getCnpj(),
                    pjDTO.getInscricaoEstadual(),
                    pjDTO.getInscricaoMunicipal(),
                    pjDTO.getPais(),
                    pjDTO.getRegimeTributario(),
                    pjDTO.getNaturezaJuridica(),
                    pjDTO.getCodigoAtividade(),
                    pjDTO.getResponsavel(),
                    pjDTO.getCpfResponsavel(),
                    pjDTO.getSituacaoCadastral()
            );
        }
        throw new IllegalArgumentException("Tipo de pessoa inválido: " + pessoaDTO.getClass().getSimpleName());
    }

}

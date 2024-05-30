package br.com.gabrizord.bmbackend.services;

import br.com.gabrizord.bmbackend.entities.Pessoa;
import br.com.gabrizord.bmbackend.entities.PessoaDTO;
import br.com.gabrizord.bmbackend.entities.PessoaFisica;
import br.com.gabrizord.bmbackend.entities.PessoaJuridica;
import br.com.gabrizord.bmbackend.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
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

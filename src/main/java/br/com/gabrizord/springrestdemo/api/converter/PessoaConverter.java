package br.com.gabrizord.springrestdemo.api.converter;

import br.com.gabrizord.springrestdemo.api.dto.PessoaDTO;
import br.com.gabrizord.springrestdemo.api.dto.PessoaFisicaDTO;
import br.com.gabrizord.springrestdemo.api.dto.PessoaJuridicaDTO;
import br.com.gabrizord.springrestdemo.domain.entities.Pessoa;
import br.com.gabrizord.springrestdemo.domain.entities.PessoaFisica;
import br.com.gabrizord.springrestdemo.domain.entities.PessoaJuridica;

public class PessoaConverter {

    public static Pessoa toEntity(PessoaDTO pessoaDTO) {
        if (pessoaDTO instanceof PessoaFisicaDTO) {
            return toEntity((PessoaFisicaDTO) pessoaDTO);
        } else if (pessoaDTO instanceof PessoaJuridicaDTO) {
            return toEntity((PessoaJuridicaDTO) pessoaDTO);
        }
        return new Pessoa(
                pessoaDTO.getNome(),
                pessoaDTO.getEndereco(),
                pessoaDTO.getEmail(),
                pessoaDTO.getTelefone()
        );
    }

    public static PessoaFisica toEntity(PessoaFisicaDTO pessoaFisicaDTO) {
        return new PessoaFisica(
                pessoaFisicaDTO.getNome(),
                pessoaFisicaDTO.getEndereco(),
                pessoaFisicaDTO.getEmail(),
                pessoaFisicaDTO.getTelefone(),
                pessoaFisicaDTO.getCpf(),
                pessoaFisicaDTO.getRg()
        );
    }

    public static PessoaJuridica toEntity(PessoaJuridicaDTO pessoaJuridicaDTO) {
        return new PessoaJuridica(
                pessoaJuridicaDTO.getNome(),
                pessoaJuridicaDTO.getEndereco(),
                pessoaJuridicaDTO.getEmail(),
                pessoaJuridicaDTO.getTelefone(),
                pessoaJuridicaDTO.getCnpj(),
                pessoaJuridicaDTO.getInscricaoEstadual(),
                pessoaJuridicaDTO.getInscricaoMunicipal(),
                pessoaJuridicaDTO.getPais(),
                pessoaJuridicaDTO.getRegimeTributario(),
                pessoaJuridicaDTO.getNaturezaJuridica(),
                pessoaJuridicaDTO.getCodigoAtividade(),
                pessoaJuridicaDTO.getResponsavel(),
                pessoaJuridicaDTO.getCpfResponsavel(),
                pessoaJuridicaDTO.getSituacaoCadastral()
        );
    }
}

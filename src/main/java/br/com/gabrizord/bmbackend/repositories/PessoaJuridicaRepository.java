package br.com.gabrizord.bmbackend.repositories;

import br.com.gabrizord.bmbackend.entities.PessoaFisica;
import br.com.gabrizord.bmbackend.entities.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

    Optional<PessoaJuridica> findByCnpj(String C);

}
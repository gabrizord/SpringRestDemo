package br.com.gabrizord.springrestdemo.domain.repositories;

import br.com.gabrizord.springrestdemo.domain.entities.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

    Optional<PessoaJuridica> findByCnpj(String C);

}
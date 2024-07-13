package br.com.gabrizord.springrestdemo.domain.repositories;

import br.com.gabrizord.springrestdemo.domain.entities.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    Optional<PessoaFisica> findByCpf(String cpf);

}
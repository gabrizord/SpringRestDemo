package br.com.gabrizord.springrestdemo.repositories;

import br.com.gabrizord.springrestdemo.entities.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    Optional<PessoaFisica> findByCpf(String cpf);

}
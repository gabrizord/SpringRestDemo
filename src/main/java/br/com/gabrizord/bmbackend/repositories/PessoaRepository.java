package br.com.gabrizord.bmbackend.repositories;

import br.com.gabrizord.bmbackend.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
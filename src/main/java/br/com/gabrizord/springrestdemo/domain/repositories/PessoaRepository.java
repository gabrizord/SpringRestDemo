package br.com.gabrizord.springrestdemo.domain.repositories;

import br.com.gabrizord.springrestdemo.domain.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}

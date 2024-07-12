package br.com.gabrizord.springrestdemo.repositories;

import br.com.gabrizord.springrestdemo.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}

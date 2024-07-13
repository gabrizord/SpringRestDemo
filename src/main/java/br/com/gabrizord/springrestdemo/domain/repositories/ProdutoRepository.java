package br.com.gabrizord.springrestdemo.domain.repositories;

import br.com.gabrizord.springrestdemo.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsByCodigo(String codigo);
}

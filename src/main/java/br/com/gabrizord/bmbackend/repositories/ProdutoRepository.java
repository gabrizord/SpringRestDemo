package br.com.gabrizord.bmbackend.repositories;

import br.com.gabrizord.bmbackend.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

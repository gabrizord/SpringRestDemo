package br.com.gabrizord.springrestdemo.security.repository;

import br.com.gabrizord.springrestdemo.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}

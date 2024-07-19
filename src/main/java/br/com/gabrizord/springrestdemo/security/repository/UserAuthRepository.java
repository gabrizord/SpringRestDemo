package br.com.gabrizord.springrestdemo.security.repository;

import br.com.gabrizord.springrestdemo.security.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, UUID> {

    Optional<UserAuth> findByUsername(String username);

}

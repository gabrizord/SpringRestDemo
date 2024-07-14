package br.com.gabrizord.springrestdemo.security.repository;

import br.com.gabrizord.springrestdemo.security.enums.RoleName;
import br.com.gabrizord.springrestdemo.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    Role findByName(RoleName roleName);
}

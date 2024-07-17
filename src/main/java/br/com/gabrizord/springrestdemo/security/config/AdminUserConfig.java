package br.com.gabrizord.springrestdemo.security.config;

import br.com.gabrizord.springrestdemo.security.enums.RoleName;
import br.com.gabrizord.springrestdemo.security.model.UserAuth;
import br.com.gabrizord.springrestdemo.security.repository.RoleRepository;
import br.com.gabrizord.springrestdemo.security.repository.UserAuthRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

import static java.lang.System.*;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserAuthRepository userAuthRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(RoleRepository roleRepository, UserAuthRepository userAuthRepository, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userAuthRepository = userAuthRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    @Transactional
    public void run(String... args) {

        var roleAdmin = roleRepository.findByName(RoleName.ADMIN);
        var roleBasic = roleRepository.findByName(RoleName.BASIC);
        var userAdmin = userAuthRepository.findByUsername("admin");

        userAdmin.ifPresentOrElse(
                (user) -> out.println("User admin already exists"),
                () -> {
                    var user = new UserAuth();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("admin"));
                    user.setRoles(Set.of(roleBasic, roleAdmin));
                    userAuthRepository.save(user);
                }
        );
    }
}

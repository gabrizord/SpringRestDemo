package br.com.gabrizord.bmbackend.utils;

import br.com.gabrizord.bmbackend.entities.PessoaFisica;
import br.com.gabrizord.bmbackend.entities.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final EntityManager entityManager;

    @Autowired
    public DataLoader(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Insere algumas Pessoas Jurídicas
        PessoaJuridica pessoaJuridica1 = new PessoaJuridica(
                "Empresa A LTDA",
                "Rua das Empresas, 123",
                "empresaA@gmail.com",
                "(11) 1234-5678",
                "12345678000123",
                "123456789012",
                "987654321098",
                "Brasil",
                "Simples Nacional",
                "Sociedade Limitada",
                "123456",
                "Fulano da Silva",
                "98765432100",
                "Ativa"
        );
        entityManager.persist(pessoaJuridica1);

        PessoaJuridica pessoaJuridica2 = new PessoaJuridica(
                "Empresa B S/A",
                "Av. das Indústrias, 456",
                "empresaB@gmail.com",
                "(11) 9876-5432",
                "12345678000234",
                "123456789013",
                "987654321097",
                "Brasil",
                "Lucro Real",
                "Sociedade Anônima",
                "654321",
                "Beltrano de Souza",
                "98765432101",
                "Ativa"
        );
        entityManager.persist(pessoaJuridica2);

        // Insere algumas Pessoas Físicas
        PessoaFisica pessoaFisica1 = new PessoaFisica(
                "Fulano da Silva",
                "Rua dos Testes, 789",
                "fulano@gmail.com",
                "(11) 98765-4321",
                "98765432100",
                "123456789"
        );
        entityManager.persist(pessoaFisica1);

        PessoaFisica pessoaFisica2 = new PessoaFisica(
                "Ciclano Oliveira",
                "Av. dos Dados, 321",
                "ciclano@gmail.com",
                "(11) 1234-5678",
                "98765432101",
                "987654321"
        );
        entityManager.persist(pessoaFisica2);
    }
}

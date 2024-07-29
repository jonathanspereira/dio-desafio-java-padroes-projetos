package one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.repository;

import one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}

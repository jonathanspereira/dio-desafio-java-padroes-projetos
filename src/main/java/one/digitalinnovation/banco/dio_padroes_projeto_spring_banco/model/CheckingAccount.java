package one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.model;

import jakarta.persistence.Entity;

@Entity
public class CheckingAccount extends Account{
    public CheckingAccount() {}

    public CheckingAccount(String accountId, double balance) {
        super(accountId, balance);
    }

    @Override
    public void performTransaction(double amount) {
        balance += amount; // Permitir saques descoberto
    }
}

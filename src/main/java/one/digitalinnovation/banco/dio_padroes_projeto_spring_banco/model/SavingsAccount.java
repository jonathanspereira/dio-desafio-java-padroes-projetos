package one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.model;

import jakarta.persistence.Entity;

@Entity
public class SavingsAccount extends Account{
    public SavingsAccount() {}

    public SavingsAccount(String accountId, double balance) {
        super(accountId, balance);
    }

    @Override
    public void performTransaction(double amount) {
        if (balance + amount < 0) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal.");
        }
        balance += amount;
    }
}

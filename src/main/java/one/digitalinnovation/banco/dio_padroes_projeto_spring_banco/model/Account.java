package one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public  abstract class Account {

    @Id
    private String accountId;
    protected double balance;

    public Account() {}

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public abstract void performTransaction(double amount);

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

package one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.service;

import one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.client.TransactionValidationClient;
import one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.event.TransactionEvent;
import one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.model.Account;
import one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.model.CheckingAccount;
import one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.model.SavingsAccount;
import one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class BankSystemService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private TransactionValidationClient validationClient;

    public void createAccount(String accountId, String accountType, double initialBalance) {
        if (accountRepository.existsById(accountId)) {
            throw new IllegalArgumentException("Account already exists!");
        }
        Account account;
        if ("savings".equalsIgnoreCase(accountType)) {
            account = new SavingsAccount(accountId, initialBalance);
        } else if ("checking".equalsIgnoreCase(accountType)) {
            account = new CheckingAccount(accountId, initialBalance);
        } else {
            throw new IllegalArgumentException("Invalid account type.");
        }
        accountRepository.save(account);
    }

    public double getBalance(String accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found!"))
                .getBalance();
    }

    public void performTransaction(String accountId, double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found!"));
        if (!validationClient.validateTransaction(accountId, amount)) {
            throw new IllegalArgumentException("Transaction validation failed!");
        }
        account.performTransaction(amount);
        accountRepository.save(account);
        eventPublisher.publishEvent(new TransactionEvent(this, accountId, amount));
    }
}

package one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.event;

import org.springframework.context.ApplicationEvent;

public class TransactionEvent extends ApplicationEvent {

    private String accountId;
    private double amount;

    public TransactionEvent(Object source, String accountId, double amount) {
        super(source);
        this.accountId = accountId;
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }
}

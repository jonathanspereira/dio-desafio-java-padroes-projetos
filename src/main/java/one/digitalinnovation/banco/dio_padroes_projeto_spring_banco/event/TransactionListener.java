package one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {
    @EventListener
    public void handleTransactionEvent(TransactionEvent event) {
        System.out.println("Transaction Notification: Account " + event.getAccountId() + " performed a transaction of " + event.getAmount());
    }
}

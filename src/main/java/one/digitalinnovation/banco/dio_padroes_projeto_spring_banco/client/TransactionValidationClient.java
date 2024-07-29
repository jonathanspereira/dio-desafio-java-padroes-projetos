package one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "transactionValidationClient", url = "http://localhost:8080/validation")
public interface TransactionValidationClient {

    @PostMapping("/validate")
    boolean validateTransaction(@RequestParam("accountId") String accountId, @RequestParam("amount") double amount);
}

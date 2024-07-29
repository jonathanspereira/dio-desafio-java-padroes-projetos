package one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.controller;

import one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.service.BankSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class BankSystemController {

    @Autowired
    private BankSystemService bankSystemService;

    @PostMapping
    public void createAccount(@RequestParam String accountId, @RequestParam String accountType, @RequestParam double initialBalance) {
        bankSystemService.createAccount(accountId, accountType, initialBalance);
    }

    @GetMapping("/{accountId}/balance")
    public double getBalance(@PathVariable String accountId) {
        return bankSystemService.getBalance(accountId);
    }

    @PostMapping("/{accountId}/transaction")
    public void performTransaction(@PathVariable String accountId, @RequestParam double amount) {
        bankSystemService.performTransaction(accountId, amount);
    }
}

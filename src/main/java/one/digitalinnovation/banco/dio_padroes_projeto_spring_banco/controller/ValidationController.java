package one.digitalinnovation.banco.dio_padroes_projeto_spring_banco.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    @PostMapping("/validate")
    public boolean validateTransaction(@RequestParam String accountId, @RequestParam double amount) {
        // Simulação de validação: sempre retorna true para simplificação
        return true;
    }
}

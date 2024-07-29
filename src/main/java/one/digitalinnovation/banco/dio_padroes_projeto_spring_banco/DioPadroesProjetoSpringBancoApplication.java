package one.digitalinnovation.banco.dio_padroes_projeto_spring_banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DioPadroesProjetoSpringBancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioPadroesProjetoSpringBancoApplication.class, args);
	}

}

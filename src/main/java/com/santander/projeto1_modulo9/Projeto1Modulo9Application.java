package com.santander.projeto1_modulo9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //habilitando para que o JPA possa auditar a aplicação
// -> @EntityListeners(AuditingEntityListener.class) da classe Usuario
//com isso ele vai setar minha data de criação e atualização sozinho
public class Projeto1Modulo9Application {

	public static void main(String[] args) {
		SpringApplication.run(Projeto1Modulo9Application.class, args);
	}


}

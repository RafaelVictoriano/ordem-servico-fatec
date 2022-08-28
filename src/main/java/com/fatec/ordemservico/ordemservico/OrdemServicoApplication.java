package com.fatec.ordemservico.ordemservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class OrdemServicoApplication {


	public static void main(String[] args) {
		SpringApplication.run(OrdemServicoApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}

}

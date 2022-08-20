package com.agence.global.projetoAgence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories
public class ProjetoAgenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoAgenceApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("fleetmg@!"));
	}

}

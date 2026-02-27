package br.com.samu.lumina;

import br.com.samu.lumina.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LuminaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LuminaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.exibeMenu();

        }

    }

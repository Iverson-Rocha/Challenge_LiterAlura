package br.com.iverson.literatura;

import br.com.iverson.literatura.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class LiteraturaApplication  {

	@Autowired
	private Principal principal;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		// Chama o menu quando a aplicação estiver pronta
		principal.exibeMenu();
	}
}


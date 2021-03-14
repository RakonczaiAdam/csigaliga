package hu.dreamteam.snailleague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SnailleagueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnailleagueApplication.class, args);
	}

}

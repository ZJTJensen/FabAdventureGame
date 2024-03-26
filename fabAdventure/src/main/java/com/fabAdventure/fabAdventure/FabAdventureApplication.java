package com.fabAdventure.fabAdventure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FabAdventureApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabAdventureApplication.class, args);
	}

}

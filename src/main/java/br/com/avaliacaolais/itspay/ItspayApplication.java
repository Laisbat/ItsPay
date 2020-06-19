package br.com.avaliacaolais.itspay;

import org.flywaydb.core.api.MigrationVersion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class ItspayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItspayApplication.class, args);
	}

	@Bean
	public FlywayMigrationStrategy repairStrategy() {
		return flyway -> {
			if (flyway.getConfiguration().getBaselineVersion().compareTo(MigrationVersion.fromVersion("8")) == -1) {
				// Reparar schema_version devido ao update do flyway de 3.x para 5.x
				flyway.repair();
			}
			flyway.migrate();
		};
}
}

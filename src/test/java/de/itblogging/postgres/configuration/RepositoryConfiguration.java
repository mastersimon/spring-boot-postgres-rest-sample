package de.itblogging.postgres.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"de.itblogging.postgres.domain"})
@EnableJpaRepositories(basePackages = {"de.itblogging.postgres.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}

package de.itblogging.postgres;

import de.itblogging.postgres.configuration.RepositoryConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RepositoryConfiguration.class)
public class SimpleSpringBootPostgresSampleApplicationTests {

	@Test
	public void contextLoads() {
	}

}

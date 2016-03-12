package de.itblogging.postgres.repositories;

import de.itblogging.postgres.domain.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}

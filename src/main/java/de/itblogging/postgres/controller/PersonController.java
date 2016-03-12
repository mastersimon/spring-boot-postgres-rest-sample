package de.itblogging.postgres.controller;

import de.itblogging.postgres.domain.Person;
import de.itblogging.postgres.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String listAllPersons() {
        final Iterable<Person> allPersons = personRepository.findAll();
        return allPersons.toString();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createPerson(@RequestBody final Person person, final UriComponentsBuilder uriBuilder) {
        personRepository.save(person);

        final URI location = uriBuilder.path("persons/{personId}")
                .buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(location).body(person);
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable final int personId) {
        final Person person = personRepository.findOne(personId);
        if(person == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(person);
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable final int personId) {
        personRepository.delete(personId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.PATCH)
    public ResponseEntity updatePerson(@PathVariable final int personId, @RequestBody final Person person) {
        final boolean personExists = personRepository.exists(personId);

        if (personExists) {
            person.setId(personId);
            personRepository.save(person);
            return ResponseEntity.ok(person);
        }

        return ResponseEntity.notFound().build();
    }


}

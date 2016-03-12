package de.itblogging.postgres.repositories;

import de.itblogging.postgres.configuration.RepositoryConfiguration;
import de.itblogging.postgres.domain.Person;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class PersonRepositoryTest {

    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Test
    public void testSaveProduct() {

        final Person person = new Person();
        person.setFirstName("Simon");
        person.setLastName("Michel");

        // create to db
        personRepository.save(person);
        Assert.assertNotNull("Person object", person);
        Assert.assertNotNull("Person ID", person.getId());
        Assert.assertNotNull("Person first name", person.getFirstName());
        Assert.assertNotNull("Person last name", person.getLastName());

        // read from db
        final Person findOnePerson = personRepository.findOne(person.getId());
        Assert.assertNotNull("Person object", findOnePerson);
        Assert.assertNotNull("Person ID", findOnePerson.getId());
        Assert.assertNotNull("Person first name", findOnePerson.getFirstName());
        Assert.assertNotNull("Person last name", findOnePerson.getLastName());

        Assert.assertEquals(person.getId(), findOnePerson.getId());
        Assert.assertEquals(person.getFirstName(), findOnePerson.getFirstName());
        org.junit.Assert.assertEquals(person.getLastName(), findOnePerson.getLastName());

        // update last name
        findOnePerson.setLastName("Micheeeeel");
        personRepository.save(findOnePerson);

        final Person updatedLastName = personRepository.findOne(findOnePerson.getId());
        Assert.assertEquals("Updated last name", findOnePerson.getLastName(), updatedLastName.getLastName());

        final Iterable<Person> allPersons = personRepository.findAll();

        int total = 0;
        for (final Person allPerson : allPersons) {
            total++;
        }

        // should be 2 here, because of the import.sql import
        Assert.assertEquals("Total person count", 2, total);

        // delete person
        personRepository.delete(person.getId());
        final Person deletedPerson = personRepository.findOne(person.getId());
        Assert.assertNull("Person null check", deletedPerson);

    }
}

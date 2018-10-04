package app.dao;

import app.model.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import static org.junit.Assert.*;

public class PersonDAOTest {

    private EmbeddedDatabase embeddedDatabase;
    private PersonDAO personDAO;

    private final long FIRST_PERSON = 1L;
    private final long SECOND_PERSON = 2L;

    @Before
    public void setUp() throws Exception {
        embeddedDatabase = new EmbeddedDatabaseBuilder()
                .addScript("schema.sql")
                .addScript("data.sql")
                .setType(EmbeddedDatabaseType.H2)
                .build();
        personDAO = new PersonDAO(embeddedDatabase);
    }

    @After
    public void tearDown() throws Exception {
        embeddedDatabase.shutdown();
    }

    @Test
    public void getPersonById() {
        assertEquals(personDAO.getPersonById(FIRST_PERSON).getFirstName(), "a");
        assertEquals(personDAO.getPersonById(SECOND_PERSON).getFirstName(), "b");
    }

    @Test
    public void getAllPersons() {
        assertNotNull(personDAO.getAllPersons());
        assertEquals(personDAO.getAllPersons().size(), 3);
    }

    @Test
    public void deletePerson() {
        Person person = new Person();
        person.setId(FIRST_PERSON);
        personDAO.deletePerson(person);
        assertNull(personDAO.getPersonById(FIRST_PERSON));
    }

    @Test
    public void updatePerson() {
        Person person = personDAO.getPersonById(FIRST_PERSON);
        person.setFirstName("update");
        personDAO.updatePerson(person);
        person = personDAO.getPersonById(FIRST_PERSON);
        assertEquals(person.getFirstName(), "update");
    }

    @Test
    public void createPerson() {
        personDAO.createPerson(new Person(4L, 20, "d", "t"));
        assertEquals(personDAO.getPersonById(4L).getFirstName(), "d");
    }
}
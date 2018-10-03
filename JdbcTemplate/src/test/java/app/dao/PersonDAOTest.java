package app.dao;

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
        assertEquals(personDAO.getPersonById(1L).getFirstName(), "a");
        assertEquals(personDAO.getPersonById(2L).getFirstName(), "b");
    }

    @Test
    public void getAllPersons() {
        assertNotNull(personDAO.getAllPersons());
        assertEquals(personDAO.getAllPersons().size(), 3);
    }

    @Test
    public void deletePerson() {
    }

    @Test
    public void updatePerson() {
    }

    @Test
    public void createPerson() {
    }
}
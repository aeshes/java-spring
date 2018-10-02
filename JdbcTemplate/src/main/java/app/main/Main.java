package app.main;

import app.config.AppConfig;
import app.dao.PersonDAO;
import app.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        PersonDAO dao = ctx.getBean(PersonDAO.class);

        System.out.println("List of persons is:");
        for (Person p : dao.getAllPersons()) {
            System.out.println(p);
        }
    }
}

package knights;

import knights.base.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightsMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/spring/knight.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}

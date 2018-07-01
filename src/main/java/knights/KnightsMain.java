package knights;

import knights.base.Knight;
import knights.config.KnightsConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KnightsMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(KnightsConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}

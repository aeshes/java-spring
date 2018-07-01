package knights;

import java.io.PrintStream;

public class RescueDamselQuest {

    private PrintStream stream;

    public RescueDamselQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to rescue the damsel");
    }
}

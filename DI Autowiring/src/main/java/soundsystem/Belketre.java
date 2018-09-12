package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class Belketre implements CompactDisc {

    private String title = "March to the Black Holocaust";
    private String name = "Night of sadness";

    public void play() {
        System.out.println("Playing " + title + " by " + name);
    }
}

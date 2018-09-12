package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class Belketre implements CompactDisc {

    private String title = "Belketre, March to the Black Holocaust";
    private String name = "Night of Sadness";

    public void play() {
        System.out.println("Playing " + name + " by " + title);
    }
}

package knights;

import knights.base.Quest;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class BraveKnightTest {
    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = mock(Quest.class);
        Minstrel minstrel = mock(Minstrel.class);
        BraveKnight knight = new BraveKnight(mockQuest, minstrel);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}
package jp.ac.uryukyu.ie.e205728.presenter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestTest {
    @Test void questHasStory(){
        Quest target = new Quest();
        assertNotNull(target.randomDice(), "There should be a story in quest.");
    }
}

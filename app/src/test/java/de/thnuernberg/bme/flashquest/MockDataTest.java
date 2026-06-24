package de.thnuernberg.bme.flashquest;



import static org.junit.Assert.*;

import de.thnuernberg.bme.flashquest.data.MockData;
import de.thnuernberg.bme.flashquest.models.Flashcard;

import org.junit.Test;

import java.util.ArrayList;

public class MockDataTest {

    @Test
    public void mockDataContainsCards() {

        ArrayList<Flashcard> cards =
                MockData.getFlashcards();

        assertTrue(cards.size() > 0);
    }
}
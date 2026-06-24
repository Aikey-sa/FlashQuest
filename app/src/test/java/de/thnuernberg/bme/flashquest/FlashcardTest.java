package de.thnuernberg.bme.flashquest;



import static org.junit.Assert.*;

import de.thnuernberg.bme.flashquest.models.Flashcard;

import org.junit.Test;

public class FlashcardTest {

    @Test
    public void flashcardStoresQuestionAndAnswer() {

        Flashcard card =
                new Flashcard("Dog", "犬");

        assertEquals(
                "Dog",
                card.getQuestion()
        );

        assertEquals(
                "犬",
                card.getAnswer()
        );
    }
}
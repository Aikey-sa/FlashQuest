package de.thnuernberg.bme.flashquest.data;

import de.thnuernberg.bme.flashquest.models.Flashcard;

import java.util.ArrayList;

public class MockData {

    public static ArrayList<Flashcard> getFlashcards() {

        ArrayList<Flashcard> flashcards = new ArrayList<>();

        flashcards.add(new Flashcard(
                "What is the capital of Japan?",
                "Tokyo"
        ));

        flashcards.add(new Flashcard(
                "What does HTML stand for?",
                "HyperText Markup Language"
        ));

        flashcards.add(new Flashcard(
                "What is 5 + 7?",
                "12"
        ));

        return flashcards;
    }
}
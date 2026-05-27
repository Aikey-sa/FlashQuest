package de.thnuernberg.bme.flashquest.data;

import de.thnuernberg.bme.flashquest.models.Flashcard;

import java.util.ArrayList;

public class MockData {

    public static ArrayList<Flashcard> getFlashcards() {

        ArrayList<Flashcard> flashcards = new ArrayList<>();

        flashcards.add(new Flashcard("犬 (Inu)", "Dog"));
        flashcards.add(new Flashcard("猫 (Neko)", "Cat"));
        flashcards.add(new Flashcard("水 (Mizu)", "Water"));
        flashcards.add(new Flashcard("火 (Hi)", "Fire"));
        flashcards.add(new Flashcard("木 (Ki)", "Tree"));
        flashcards.add(new Flashcard("山 (Yama)", "Mountain"));
        flashcards.add(new Flashcard("空 (Sora)", "Sky"));
        flashcards.add(new Flashcard("本 (Hon)", "Book"));

        return flashcards;
    }
}
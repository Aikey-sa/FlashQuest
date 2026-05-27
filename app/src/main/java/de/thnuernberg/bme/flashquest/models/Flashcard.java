package de.thnuernberg.bme.flashquest.models;
public class Flashcard {

    private String question;
    private String answer;
    private boolean known;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.known = false;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isKnown() {
        return known;
    }

    public void setKnown(boolean known) {
        this.known = known;
    }
}
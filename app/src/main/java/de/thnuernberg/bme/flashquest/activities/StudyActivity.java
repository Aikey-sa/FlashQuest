package de.thnuernberg.bme.flashquest.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.thnuernberg.bme.flashquest.R;
import de.thnuernberg.bme.flashquest.data.MockData;
import de.thnuernberg.bme.flashquest.models.Flashcard;

import java.util.ArrayList;

public class StudyActivity extends AppCompatActivity {

    TextView txtQuestion;
    TextView txtAnswer;
    TextView txtProgress;
    TextView txtPoints;

    Button btnReveal;
    Button btnKnown;
    Button btnUnknown;
    Button btnNext;

    ArrayList<Flashcard> flashcards;

    int currentIndex = 0;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        txtQuestion = findViewById(R.id.txtQuestion);
        txtAnswer = findViewById(R.id.txtAnswer);
        txtProgress = findViewById(R.id.txtProgress);
        txtPoints = findViewById(R.id.txtPoints);

        btnReveal = findViewById(R.id.btnReveal);
        btnKnown = findViewById(R.id.btnKnown);
        btnUnknown = findViewById(R.id.btnUnknown);
        btnNext = findViewById(R.id.btnNext);

        flashcards = MockData.getFlashcards();

        displayCard();

        btnReveal.setOnClickListener(v -> {
            txtAnswer.setVisibility(View.VISIBLE);
        });

        btnKnown.setOnClickListener(v -> {

            points += 1;

            txtPoints.setText("Points: " + points);

            flashcards.get(currentIndex).setKnown(true);
        });

        btnUnknown.setOnClickListener(v -> {

            flashcards.get(currentIndex).setKnown(false);
        });

        btnNext.setOnClickListener(v -> {

            currentIndex++;

            if(currentIndex >= flashcards.size()) {
                currentIndex = 0;
            }

            displayCard();
        });
    }

    private void displayCard() {

        Flashcard currentCard = flashcards.get(currentIndex);

        txtQuestion.setText(currentCard.getQuestion());

        txtAnswer.setText(currentCard.getAnswer());

        txtAnswer.setVisibility(View.GONE);

        txtProgress.setText(
                "Card " +
                        (currentIndex + 1) +
                        "/" +
                        flashcards.size()
        );
    }
}
package de.thnuernberg.bme.flashquest.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.thnuernberg.bme.flashquest.R;
import de.thnuernberg.bme.flashquest.data.MockData;
import de.thnuernberg.bme.flashquest.models.Flashcard;
import de.thnuernberg.bme.flashquest.utils.PointsManager;

import java.util.ArrayList;

public class StudyActivity extends AppCompatActivity {

    TextView txtQuestion;
    TextView txtAnswer;
    TextView txtProgress;
    TextView txtPoints;
    TextView txtKnownProgress;

    Button btnReveal;
    Button btnKnown;
    Button btnUnknown;
    Button btnNext;

    ArrayList<Flashcard> flashcards;

    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        txtQuestion = findViewById(R.id.txtQuestion);
        txtAnswer = findViewById(R.id.txtAnswer);
        txtProgress = findViewById(R.id.txtProgress);
        txtPoints = findViewById(R.id.txtPoints);
        txtKnownProgress = findViewById(R.id.txtKnownProgress);

        btnReveal = findViewById(R.id.btnReveal);
        btnKnown = findViewById(R.id.btnKnown);
        btnUnknown = findViewById(R.id.btnUnknown);
        btnNext = findViewById(R.id.btnNext);

        flashcards = MockData.getFlashcards();
        updateKnownProgress();
        txtPoints.setText(
                "Points: " +
                        PointsManager.getPoints(this)
        );

        displayCard();

        btnReveal.setOnClickListener(v -> {
            txtAnswer.setVisibility(View.VISIBLE);
        });

        btnKnown.setOnClickListener(v -> {

            Flashcard currentCard =
                    flashcards.get(currentIndex);

            if(!currentCard.isKnown()) {currentCard.setKnown(true);

                PointsManager.addPoints(this, 1);

                txtPoints.setText("Points: " + PointsManager.getPoints(this));

                updateKnownProgress();
            }
        });

        btnUnknown.setOnClickListener(v -> {

            flashcards.get(currentIndex).setKnown(false);
            updateKnownProgress();
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
    private void updateKnownProgress() {

        int knownCount = 0;

        for(Flashcard card : flashcards) {

            if(card.isKnown()) {

                knownCount++;
            }
        }

        txtKnownProgress.setText(
                "Known Cards: "
                        + knownCount
                        + "/"
                        + flashcards.size()
        );
    }
}
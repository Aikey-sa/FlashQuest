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
    Button btnReveal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        txtQuestion = findViewById(R.id.txtQuestion);
        txtAnswer = findViewById(R.id.txtAnswer);
        btnReveal = findViewById(R.id.btnReveal);

        ArrayList<Flashcard> flashcards =
                MockData.getFlashcards();

        Flashcard firstCard = flashcards.get(0);

        txtQuestion.setText(firstCard.getQuestion());
        txtAnswer.setText(firstCard.getAnswer());

        btnReveal.setOnClickListener(v -> {
            txtAnswer.setVisibility(View.VISIBLE);
        });
    }
}
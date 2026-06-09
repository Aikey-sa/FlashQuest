package de.thnuernberg.bme.flashquest.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import de.thnuernberg.bme.flashquest.R;



import android.content.Intent;

import android.widget.Button;

public class GameModeActivity extends AppCompatActivity {

    Button btnQuizGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        btnQuizGame = findViewById(R.id.btnQuizGame);

        btnQuizGame.setOnClickListener(v -> {

            Intent intent = new Intent(
                    GameModeActivity.this,
                    QuizGameActivity.class
            );

            startActivity(intent);
        });
    }
}
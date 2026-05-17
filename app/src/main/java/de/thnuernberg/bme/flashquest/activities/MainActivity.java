package de.thnuernberg.bme.flashquest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import de.thnuernberg.bme.flashquest.R;

public class MainActivity extends AppCompatActivity {

    Button btnDecks;
    Button btnGames;
    Button btnLeaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDecks = findViewById(R.id.btnDecks);
        btnGames = findViewById(R.id.btnGames);
        btnLeaderboard = findViewById(R.id.btnLeaderboard);

        btnDecks.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    DeckListActivity.class
            );
            startActivity(intent);
        });

        btnGames.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    GameModeActivity.class
            );
            startActivity(intent);
        });

        btnLeaderboard.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    LeaderboardActivity.class
            );
            startActivity(intent);
        });
    }
}
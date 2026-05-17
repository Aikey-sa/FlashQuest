package de.thnuernberg.bme.flashquest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import de.thnuernberg.bme.flashquest.R;

public class DeckListActivity extends AppCompatActivity {

    Button btnStartStudy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_list);

        btnStartStudy = findViewById(R.id.btnStartStudy);

        btnStartStudy.setOnClickListener(v -> {

            Intent intent = new Intent(
                    DeckListActivity.this,
                    StudyActivity.class
            );

            startActivity(intent);
        });
    }
}
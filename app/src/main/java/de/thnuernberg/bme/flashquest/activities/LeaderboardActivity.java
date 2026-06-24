package de.thnuernberg.bme.flashquest.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import de.thnuernberg.bme.flashquest.R;

import android.widget.TextView;

import de.thnuernberg.bme.flashquest.utils.PointsManager;

public class LeaderboardActivity extends AppCompatActivity {

    TextView txtTotalPoints;

    @Override
    protected void onCreate(
            Bundle savedInstanceState
    ) {

        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.activity_leaderboard
        );

        txtTotalPoints =
                findViewById(
                        R.id.txtTotalPoints
                );

        txtTotalPoints.setText(
                "Total Points: " +
                        PointsManager.getPoints(this)
        );
    }
    @Override
    protected void onResume() {

        super.onResume();

        txtTotalPoints.setText(
                "Total Points: " +
                        PointsManager.getPoints(this)
        );
    }
}
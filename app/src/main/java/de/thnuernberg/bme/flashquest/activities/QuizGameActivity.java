package de.thnuernberg.bme.flashquest.activities;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.thnuernberg.bme.flashquest.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class QuizGameActivity extends AppCompatActivity {

    TextView txtPoints;
    TextView txtSelected1;
    TextView txtSelected2;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;

    ArrayList<Button> buttons = new ArrayList<>();

    ArrayList<String> values = new ArrayList<>();

    HashMap<String, String> pairs = new HashMap<>();

    Button firstButton = null;
    Button secondButton = null;

    String firstValue = "";
    String secondValue = "";

    int points = 0;

    boolean busy = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);

        txtPoints = findViewById(R.id.txtPoints);
        txtSelected1 = findViewById(R.id.txtSelected1);
        txtSelected2 = findViewById(R.id.txtSelected2);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);
        buttons.add(btn4);
        buttons.add(btn5);
        buttons.add(btn6);

        setupGame();
    }

    private void setupGame() {

        pairs.put("Dog", "犬");
        pairs.put("Cat", "猫");
        pairs.put("Fire", "火");

        values.add("Dog");
        values.add("犬");

        values.add("Cat");
        values.add("猫");

        values.add("Fire");
        values.add("火");

        Collections.shuffle(values);

        for(int i = 0; i < buttons.size(); i++) {

            Button currentButton = buttons.get(i);

            currentButton.setTag(values.get(i));

            currentButton.setText("?");

            currentButton.setOnClickListener(v -> {

                if(busy) {
                    return;
                }

                handleSelection(currentButton);
            });
        }
    }

    private void handleSelection(Button selectedButton) {

        if(selectedButton == firstButton) {
            return;
        }

        String value =
                selectedButton.getTag().toString();

        if(firstButton == null) {

            firstButton = selectedButton;

            firstValue = value;

            txtSelected1.setText(value);

        }

        else if(secondButton == null) {

            secondButton = selectedButton;

            secondValue = value;

            txtSelected2.setText(value);

            checkMatch();
        }
    }

    private void checkMatch() {

        busy = true;

        boolean isMatch =

                (pairs.containsKey(firstValue)
                        && pairs.get(firstValue)
                        .equals(secondValue))

                        ||

                        (pairs.containsKey(secondValue)
                                && pairs.get(secondValue)
                                .equals(firstValue));

        Handler handler = new Handler();

        handler.postDelayed(() -> {

            if(isMatch) {

                points++;

                txtPoints.setText(
                        "Points: " + points
                );

                firstButton.setBackgroundColor(
                        Color.GREEN
                );

                secondButton.setBackgroundColor(
                        Color.GREEN
                );

                firstButton.setEnabled(false);
                secondButton.setEnabled(false);
            }

            resetSelection();

        }, 1000);
    }

    private void resetSelection() {

        txtSelected1.setText("");
        txtSelected2.setText("");

        firstButton = null;
        secondButton = null;

        firstValue = "";
        secondValue = "";

        busy = false;
    }
}
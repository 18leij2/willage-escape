package com.example.willageescape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Win extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        WindowInsetsControllerCompat windowInsetsController = WindowCompat
                .getInsetsController(getWindow(), getWindow().getDecorView());
        windowInsetsController.setSystemBarsBehavior(WindowInsetsControllerCompat
                .BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);

        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());

        final Button restartGame = findViewById(R.id.restartGameWin);
        final Button quitGame = findViewById(R.id.quitGameWin);

        final TextView scoreText = findViewById(R.id.scoreText);
        final String getPlayerScore = getIntent().getStringExtra("score");
        scoreText.setText("Final Score: " + getPlayerScore);


        restartGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent configIntentWin = new Intent(Win.this, ConfigScreen.class);
                startActivity(configIntentWin);
            }
        });

        quitGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                endGame();
            }
        });
    }

    private void endGame() {
        this.finishAffinity();
    }
}
package com.example.willageescape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        WindowInsetsControllerCompat windowInsetsController = WindowCompat
                .getInsetsController(getWindow(), getWindow().getDecorView());
        windowInsetsController.setSystemBarsBehavior(WindowInsetsControllerCompat
                .BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);

        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());

        final Button restartGame = findViewById(R.id.restartGame);
        final Button quitGame = findViewById(R.id.quitGame);

        restartGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent configIntent = new Intent(GameOver.this, ConfigScreen.class);
                startActivity(configIntent);
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
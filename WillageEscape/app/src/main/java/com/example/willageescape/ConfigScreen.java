package com.example.willageescape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ConfigScreen extends AppCompatActivity {
    private int difficulty = 2;
    private int cycle = 0;

    private String getPlayerName;

    private boolean inputtedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_screen);

        WindowInsetsControllerCompat windowInsetsController =
                WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        windowInsetsController.setSystemBarsBehavior(WindowInsetsControllerCompat
                .BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);

        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());

        final EditText playerName = findViewById(R.id.playerName);
        final Button startRealGame = findViewById(R.id.realStartGame);
        final ImageButton easyButton = findViewById(R.id.easyButton);
        LinearLayout easyColor = findViewById(R.id.easyColor);
        final ImageButton mediumButton = findViewById(R.id.mediumButton);
        LinearLayout mediumColor = findViewById(R.id.mediumColor);
        final ImageButton hardButton = findViewById(R.id.hardButton);
        LinearLayout hardColor = findViewById(R.id.hardColor);
        ImageButton charButton = findViewById(R.id.jasonButton);
        int[] characters = {R.drawable.jason, R.drawable.prateek,
                            R.drawable.chanwoo, R.drawable.sylvia,
                            R.drawable.eric, R.drawable.enya };

        charButton.setImageDrawable(getDrawable(characters[0]));

        charButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                cycle++;
                if (cycle == 6) {
                    cycle = 0;
                }

                charButton.setImageDrawable(getDrawable(characters[cycle]));
            }
        });

        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (difficulty != 1) {
                    mediumColor.setBackgroundColor(Color.parseColor("#474C54"));
                    hardColor.setBackgroundColor(Color.parseColor("#474C54"));
                    easyColor.setBackgroundColor(Color.parseColor("#1BD143"));
                    difficulty = 1;
                }
            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (difficulty != 2) {
                    easyColor.setBackgroundColor(Color.parseColor("#474C54"));
                    hardColor.setBackgroundColor(Color.parseColor("#474C54"));
                    mediumColor.setBackgroundColor(Color.parseColor("#D1A128"));
                    difficulty = 2;
                }
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (difficulty != 3) {
                    easyColor.setBackgroundColor(Color.parseColor("#474C54"));
                    mediumColor.setBackgroundColor(Color.parseColor("#474C54"));
                    hardColor.setBackgroundColor(Color.parseColor("#D12B28"));
                    difficulty = 3;
                }
            }
        });

        startRealGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getPlayerName = (playerName.getText().toString()).trim();
                if (getPlayerName == null || getPlayerName.isEmpty()
                        || getPlayerName.length() > 10) {
                    Toast.makeText(ConfigScreen.this, "Enter a valid name that has "
                            + "10 or less characters.", Toast.LENGTH_SHORT).show();
                } else {
                    inputtedName = true;
                    Intent gameIntent = new Intent(ConfigScreen.this,
                            MainActivity.class);
                    gameIntent.putExtra("playerName", getPlayerName);
                    gameIntent.putExtra("difficulty", difficulty);
                    gameIntent.putExtra("character", cycle);
                    startActivity(gameIntent);
                }
            }
        });
    }
    public boolean verifyUsername(String input) {
        if (input == null || input.isEmpty() || input.length() > 10) {
            System.out.println("Hello!");
            return false;
        } else {
            return true;
        }
    }
    public boolean isEasy(int choice) {
        return choice == 1;
    }

    public boolean isMedium(int choice) {
        return choice == 2;
    }

    public boolean isHard(int choice) {
        return choice == 3;
    }

    public boolean ifInputtedName() {
        return inputtedName;
    }

    public void receiveString(String input) { }
}
package com.example.willageescape;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int yUpperBound = 0;
    private int yLowerBound = 0;

    private int screenheight = 0;
    private int screenwidth = 0;

    private Button upButton = null;
    private Button downButton = null;
    private Button leftButton = null;
    private Button rightButton = null;
    private Button toMenu = null;

    private ImageView player = null;
    private ImageView reck = null;
    private ImageView bike = null;
    private ImageView stinger = null;
    private ImageView bikeRev = null;
    private ImageView reckRev = null;

    private ImageView smallLog1 = null;
    private ImageView smallLog2 = null;
    private ImageView largeLog1 = null;
    private ImageView lilypad = null;
    private ImageView lilypad2 = null;
    private ImageView lilypad3 = null;
    private ImageView largeLog2 = null;
    private ImageView smallLog3 = null;
    private ImageView smallLog4 = null;
    private ImageView[] logs = new ImageView[10];

    private boolean finished = false;
    private boolean isLogged = false;
    private boolean killPlayer = false;

    private int tileSize = 0;
    private int roadOne = 0;
    private int roadTwo = 0;
    private int roadThree = 0;
    private int roadFour = 0;
    private int roadFive = 0;
    private int riverOne = 0;
    private int riverTwo = 0;
    private int riverThree = 0;
    private int riverFour = 0;
    private int riverFive = 0;
    private int riverSix = 0;
    private Tile[][] myTiles;
    private Position playerPOS = new Position(5, 16);

    private Lives playerLives = new Lives(0);
    private Lives oldLives = new Lives(0);

    private Score playerScore;
    private TextView scoreDisplay = null;
    private TextView lives = null;

    private int startingX;
    private int startingY;

    private GameLoop gameLoop = new GameLoop(this);

    public void setYUpper(int y) {
        yUpperBound = y;
    }

    public void setYLower(int y) {
        yLowerBound = y;
    }
    private int[] characters = {R.drawable.jason, R.drawable.prateek,
                                R.drawable.chanwoo, R.drawable.sylvia,
                                R.drawable.eric, R.drawable.enya };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WindowInsetsControllerCompat windowInsetsController = WindowCompat
                .getInsetsController(getWindow(), getWindow().getDecorView());
        windowInsetsController.setSystemBarsBehavior(WindowInsetsControllerCompat
                .BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());
        final TextView playerName = findViewById(R.id.playerText);
        final ImageView playerIcon = findViewById(R.id.playerIcon);
        final TextView difficulty = findViewById(R.id.difficultyText);
        final ImageView difficultyIcon = findViewById(R.id.difficultyIcon);
        player = findViewById(R.id.player);
        reck = findViewById(R.id.rambler);
        bike = findViewById(R.id.biker);
        stinger = findViewById(R.id.stingery);
        bikeRev = findViewById(R.id.bikeRever);
        reckRev = findViewById(R.id.reckRever);
        smallLog1 = findViewById(R.id.smallLog1);
        smallLog2 = findViewById(R.id.smallLog2);
        largeLog1 = findViewById(R.id.largeLog1);
        lilypad = findViewById(R.id.lilypad);
        lilypad2 = findViewById(R.id.lilypad2);
        lilypad3 = findViewById(R.id.lilypad3);
        largeLog2 = findViewById(R.id.largeLog2);
        smallLog3 = findViewById(R.id.smallLog3);
        smallLog4 = findViewById(R.id.smallLog4);
        // final TextView lives = findViewById(R.id.lives);
        lives = findViewById(R.id.lives);
        final TextView score = findViewById(R.id.score);
        scoreDisplay = score;
        toMenu = findViewById(R.id.backButton);
        upButton = findViewById(R.id.upButton);
        downButton = findViewById(R.id.downButton);
        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);
        reck.setImageResource(R.drawable.ramblin);
        bike.setImageResource(R.drawable.bike);
        stinger.setImageResource(R.drawable.stinger);
        bikeRev.setImageResource(R.drawable.bikerev);
        reckRev.setImageResource(R.drawable.ramblinrev);
        smallLog1.setImageResource(R.drawable.log13);
        smallLog2.setImageResource(R.drawable.log13);
        largeLog1.setImageResource(R.drawable.log14);
        lilypad.setImageResource(R.drawable.lilypad);
        lilypad2.setImageResource(R.drawable.lilypad);
        lilypad3.setImageResource(R.drawable.lilypad);
        largeLog2.setImageResource(R.drawable.log14);
        smallLog3.setImageResource(R.drawable.log13);
        smallLog4.setImageResource(R.drawable.log13);
        final String getPlayerName = getIntent().getStringExtra("playerName");
        final Drawable getPlayerIcon = getDrawable(characters[getIntent()
                .getIntExtra("character", 0)]);
        final int getDifficulty = getIntent().getIntExtra("difficulty", 0);
        System.out.println(getPlayerIcon);
        playerName.setText(getPlayerName);
        playerIcon.setImageDrawable(getPlayerIcon);
        player.setImageDrawable(getPlayerIcon);
        if (getDifficulty == 1) {
            difficulty.setText("Easy");
            difficultyIcon.setImageDrawable(getDrawable(R.drawable.easy));
            lives.setText("Lives: 3");
            playerLives.setCount(3);
        } else if (getDifficulty == 2) {
            difficulty.setText("Medium");
            difficultyIcon.setImageDrawable(getDrawable(R.drawable.medium));
            lives.setText("Lives: 2");
            playerLives.setCount(2);
        } else if (getDifficulty == 3) {
            difficulty.setText("Hard");
            difficultyIcon.setImageDrawable(getDrawable(R.drawable.hard));
            lives.setText("Lives: 1");
            playerLives.setCount(1);
        }
        oldLives.setCount(playerLives.getCount());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenheight = displayMetrics.heightPixels;
        screenwidth = displayMetrics.widthPixels;
        System.out.print("h:" + screenheight + " w:" + screenwidth);
        int tileDimension = screenwidth / 9;
        tileSize = tileDimension;
        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(MainActivity.this, MainMenu.class);
                startActivity(menuIntent);
            }
        });
        upButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.printf("%f, %f \n", player.getX(), player.getY());
                player.setY(Util.moveUp(player, tileDimension, yUpperBound, playerPOS));
                Util.updateScoreIfValidUp(player, playerScore, playerPOS);
                scoreDisplay.setText("" + playerScore.getValue());
                System.out.println(playerScore.getValue());
            }
        });
        downButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player.setY(Util.moveDown(player, tileDimension, yLowerBound, playerPOS));
                scoreDisplay.setText("" + playerScore.getValue());
            }
        });
        leftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                player.setX(Util.moveLeft(player, tileDimension, playerPOS));
                scoreDisplay.setText("" + playerScore.getValue());
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.printf("%f, %f \n", player.getX(), player.getY());
                player.setX(Util.moveRight(player, tileDimension, screenwidth, playerPOS));
                scoreDisplay.setText("" + playerScore.getValue());
            }
        });
        LinearLayout layout2 = findViewById(R.id.rlMain);
        layout2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.setOrientation(LinearLayout.VERTICAL);
        layout2.setPadding(0, 170, 0, 50);
        ImageView starting = null;
        ImageView yUpper = null;
        ImageView yLower = null;
        ImageView lastTile = null;
        myTiles = new Tile[16][9];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                Tile t;
                if (i < 1) {
                    t = new GoalTile(this);
                } else if (i < 2) {
                    t = new SafeTile(this);
                } else if (i < 8) {
                    t = new RiverTile(this);
                } else if (i < 9) {
                    t = new SafeTile(this);
                } else if (i < 14) {
                    t = new RoadTile(this);
                } else {
                    t = new SafeTile(this);
                }
                myTiles[i][j] = t;
            }
        }
        generateTiles(tileDimension, starting, player, yUpper, yLower, lastTile, layout2);
    }

    public void generateTiles(int tileDimension, ImageView starting, ImageView player,
                              ImageView yUpper, ImageView yLower, ImageView lastTile,
                              LinearLayout layout2) {
        for (int i = 0; i < 16; i++) {
            LinearLayout layout3 = new LinearLayout(this);
            for (int j = 0; j < 9; j++) {
                layout3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                        .MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                layout3.setOrientation(LinearLayout.HORIZONTAL);
                int width = tileDimension;
                int height = tileDimension;
                LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width, height);
                Tile t = myTiles[i][j];
                t.getTile().setLayoutParams(parms);
                layout3.addView(t.getTile());
                if (i == 15 && j == 4) {
                    starting = t.getTile();
                    player.setLayoutParams(parms);
                }
                if (i == 0 & j == 0) {
                    yUpper = t.getTile();
                    LinearLayout.LayoutParams reckParms = new LinearLayout.LayoutParams(2
                            * width, height);
                    reck.setLayoutParams(reckParms);
                    LinearLayout.LayoutParams bikeParms = new LinearLayout.LayoutParams(width,
                            height);
                    bike.setLayoutParams(bikeParms);
                    LinearLayout.LayoutParams stingerParms = new LinearLayout.LayoutParams(3
                            * width, height);
                    stinger.setLayoutParams(stingerParms);
                    bikeRev.setLayoutParams(bikeParms);
                    reckRev.setLayoutParams(reckParms);
                    LinearLayout.LayoutParams smallLogParms = new LinearLayout
                            .LayoutParams(3 * width, height);
                    smallLog1.setLayoutParams(smallLogParms);
                    smallLog2.setLayoutParams(smallLogParms);
                    smallLog3.setLayoutParams(smallLogParms);
                    smallLog4.setLayoutParams(smallLogParms);
                    LinearLayout.LayoutParams largeLogParms = new LinearLayout
                            .LayoutParams(4 * width, height);
                    largeLog1.setLayoutParams(largeLogParms);
                    largeLog2.setLayoutParams(largeLogParms);
                    lilypad.setLayoutParams(bikeParms);
                    lilypad2.setLayoutParams(bikeParms);
                    lilypad3.setLayoutParams(bikeParms);
                }
                if (i == 15 && j == 0) {
                    yLower = t.getTile();
                }
                if (i == 15 && j == 8) {
                    lastTile = t.getTile();
                }
            }
            layout2.addView(layout3);
        }
        ImageView finalStarting = starting;
        starting.post(() -> {
            // Values should no longer be 0
            int[] point = new int[2];
            finalStarting.getLocationInWindow(point); // or getLocationInWindow(point)
            Util.setStartingX(point[0]);
            Util.setStartingY(point[1]);
            System.out.printf("yeahsss %d, %d \n", point[0], point[1]);
            player.setX(Util.getStartingX());
            player.setY(Util.getStartingY());
            playerScore = new Score(0, player.getY());
            System.out.printf("yeahsss %f, %f \n", player.getX(), player.getY());
        });
        ImageView finalYLower = yLower;
        yLower.post(() -> {
            // Values should no longer be 0
            int[] point = new int[2];
            finalYLower.getLocationOnScreen(point); // or getLocationInWindow(point)
            int x = point[0];
            int y = point[1] + tileDimension;
            setYLower(y);
            System.out.printf("lower bound bottom screen is: %d", yLowerBound);
            roadOne = y - (tileDimension * 3);
            reck.setX(0 - (2 * tileSize));
            reck.setY(roadOne);
            roadTwo = y - (tileDimension * 4);
            bikeRev.setX(screenwidth);
            bikeRev.setY(roadTwo);
            roadThree = y - (tileDimension * 5);
            stinger.setX(0 - (3 * tileSize));
            stinger.setY(roadThree);
            roadFour = y - (tileDimension * 6);
            reckRev.setX(screenwidth);
            reckRev.setY(roadFour);
            roadFive = y - (tileDimension * 7);
            bike.setX(0 - tileSize);
            bike.setY(roadFive);
            riverOne = y - (tileDimension * 9);
            riverTwo = y - (tileDimension * 10);
            riverThree = y - (tileDimension * 11);
            riverFour = y - (tileDimension * 12);
            riverFive = y - (tileDimension * 13);
            riverSix = y - (tileDimension * 14);

            smallLog1.setX(0 - (3 * tileSize));
            smallLog1.setY(riverOne);

            smallLog2.setX(3 * tileSize);
            smallLog2.setY(riverOne);

            largeLog1.setX(screenwidth);
            largeLog1.setY(riverTwo);

            lilypad.setX(4 * tileSize);
            lilypad.setY(riverThree);

            largeLog2.setX(0 - (4 * tileSize));
            largeLog2.setY(riverFour);

            lilypad2.setX(2 * tileSize);
            lilypad2.setY(riverFive);

            lilypad3.setX(6 * tileSize);
            lilypad3.setY(riverFive);

            smallLog3.setX(screenwidth);
            smallLog3.setY(riverSix);

            smallLog4.setX(3 * tileSize);
            smallLog4.setY(riverSix);
        });

        ImageView finalYUpper = yUpper;
        yUpper.post(() -> {
            // Values should no longer be 0
            int[] point = new int[2];
            finalYUpper.getLocationOnScreen(point); // or getLocationInWindow(point)
            int x = point[0];
            int y = point[1];
            setYUpper(y);
            System.out.printf("upper bound top screen is: %d", yUpperBound);
        });

        lastTile.post(() -> {
            logs[0] = smallLog1;
            logs[1] = smallLog2;
            logs[3] = largeLog1;
            logs[4] = lilypad;
            for (int i = 5; i < 10; i++) {
                logs[i] = null;
            }
            gameLoop.startLoop();
        });
    }

    public void update(int updateThing) {
        killPlayer = false;
        if (playerLives.getCount() != oldLives.getCount()) {
            lives.setText("Lives: " + playerLives.getCount());
            oldLives.setCount(playerLives.getCount());

            if (playerLives.getCount() == 0) {
                Intent gameOverIntent = new Intent(MainActivity.this, GameOver.class);
                startActivity(gameOverIntent);
            }
        }

        if ((int) player.getY() < yUpperBound + tileSize && !finished) {
            finished = true;
            Intent winScreenIntent = new Intent(MainActivity.this, Win.class);
            winScreenIntent.putExtra("score", "" + playerScore.getValue());
            startActivity(winScreenIntent);
        }

        if (updateThing % 30 == 0) {
            if (reck.getX() > screenwidth) {
                reck.setX(0 - (2 * tileSize));
            }

            if (stinger.getX() > screenwidth) {
                stinger.setX(0 - (3 * tileSize));
            }

            if (bike.getX() > screenwidth) {
                bike.setX(0 - tileSize);
            }

            if (bikeRev.getX() + tileSize < 0) {
                bikeRev.setX(screenwidth);
            }

            if (reckRev.getX() + (2 * tileSize) < 0) {
                reckRev.setX(screenwidth);
            }

            if (smallLog1.getX() > screenwidth) {
                smallLog1.setX(0 - (3 * tileSize));
            }

            if (smallLog2.getX() > screenwidth) {
                smallLog2.setX(0 - (3 * tileSize));
            }

            if (largeLog1.getX() + (4 * tileSize) < 0) {
                largeLog1.setX(screenwidth);
            }

            if (largeLog2.getX() > screenwidth) {
                largeLog2.setX(0 - (4 * tileSize));
            }

            if (smallLog3.getX() + (3 * tileSize) < 0) {
                smallLog3.setX(screenwidth);
            }

            if (smallLog4.getX() + (3 * tileSize) < 0) {
                smallLog4.setX(screenwidth);
            }
        }

        if (detectCollision(smallLog1.getX(), smallLog1.getY(), tileSize * 3, tileSize)
                || detectCollision(smallLog2.getX(), smallLog2.getY(),
                tileSize * 3, tileSize)) {
            updatePos(player, 8);
            isLogged = true;
        } else if (detectCollision(largeLog1.getX(), largeLog1.getY(), tileSize * 4, tileSize)) {
            updatePos(player, -5);
            isLogged = true;
        } else if (detectCollision(lilypad.getX(), lilypad.getY(), tileSize, tileSize)) {
            isLogged = true;
        } else if (detectCollision(lilypad2.getX(), lilypad2.getY(), tileSize, tileSize)) {
            isLogged = true;
        } else if (detectCollision(lilypad3.getX(), lilypad3.getY(), tileSize, tileSize)) {
            isLogged = true;
        } else if (detectCollision(largeLog2.getX(), largeLog2.getY(), tileSize * 4, tileSize)) {
            updatePos(player, 7);
            isLogged = true;
        } else if (detectCollision(smallLog3.getX(), smallLog3.getY(), tileSize * 3,
                tileSize) || detectCollision(smallLog4.getX(), smallLog4.getY(),
                tileSize * 3, tileSize)) {
            updatePos(player, -15);
            isLogged = true;
        } else {
            isLogged = false;
        }

        if (player.getX() > screenwidth || player.getX() + tileSize < 0) {
            killPlayer = true;
        }

        Util.updateScoreIfStepInWater(player, playerScore, lives, playerLives, playerPOS,
                isLogged, killPlayer);

        //checkForCollision();
        Collision c = new Collision(tileSize, player, lives);
        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(reck);
        vehicles.add(reckRev);
        vehicles.add(bike);
        vehicles.add(bikeRev);
        vehicles.add(stinger);
        c.checkForCollision(vehicles, playerLives, playerScore, scoreDisplay, playerPOS);

        updatePos(reck, 12);
        updatePos(stinger, 20);
        updatePos(bike, 4);
        updatePos(bikeRev, -4);
        updatePos(reckRev, -12);

        updatePos(smallLog1, 8);
        updatePos(smallLog2, 8);

        updatePos(largeLog1, -5);
        updatePos(largeLog2, 7);
        updatePos(smallLog3, -15);
        updatePos(smallLog4, -15);
    }

    public boolean detectCollision(float x2, float y2, int width2, int height2) {
        return ((player.getY() < (y2 + height2)) && ((player.getY() + tileSize) > y2)
                && ((player.getX() + tileSize / 2) < (x2 + width2))
                && (((player.getX() + tileSize / 2)) > x2));
    }

    public void updatePos(ImageView vehicle, int speed) {
        int currX = (int) vehicle.getX();
        vehicle.setX(currX + speed);
    }

    public boolean testHealthHard(int difficulty) {
        return difficulty == 1;
    }

    public int returnTileDimension(int input) {
        return input / 9;
    }

    public int returnMoveRight(int playerX, int tileDimension) {
        return playerX + tileDimension;
    }

    public int returnMoveLeft(int playerX, int tileDimension) {
        return playerX - tileDimension;
    }



    public int returnMoveUp(int playerY, int tileDimension) {
        int y = playerY;
        y -= tileDimension;
        return y;
    }

    public int returnMoveDown(int playerY, int tileDimension) {
        int y = playerY;
        y += tileDimension;
        return y;
    }

    public boolean rightOnClick(int playerX, int tileDimension, int screenwidth) {
        int x = playerX;
        x += tileDimension;
        return x + tileDimension - 1 <= screenwidth;
    }

    public boolean leftOnClick(int playerX, int tileDimension) {
        int x = playerX;
        x -= tileDimension;
        return x >= 0;
    }
}
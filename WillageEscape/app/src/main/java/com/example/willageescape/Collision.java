package com.example.willageescape;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Collision {
    private int tileSize;
    private ImageView player;
    private TextView lives;

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }
    public int getTileSize() {
        return tileSize;
    }
    public void setLives(TextView lives) {
        this.lives = lives;
    }
    public TextView getLives() {
        return lives;
    }

    public Collision(int tileSize, ImageView player, TextView lives) {
        this.tileSize = tileSize;
        this.player = player;
        this.lives = lives;
    }

    public boolean detectCollision(float x2, float y2, int width2, int height2) {
        return ((player.getY() < (y2 + height2)) && ((player.getY() + tileSize) > y2)
                && (player.getX() < (x2 + width2)) && ((player.getX() + tileSize) > x2));
    }

    public void checkForCollision(List<ImageView> vehicles, Lives playerLives, Score playerScore,
                                  TextView scoreDisplay, Position playerPOS) {
        ImageView reck = vehicles.get(0);
        ImageView reckRev = vehicles.get(1);
        ImageView bike = vehicles.get(2);
        ImageView bikeRev = vehicles.get(3);
        ImageView stinger = vehicles.get(4);
        if (detectCollision(reck.getX(), reck.getY(), (tileSize * 2), tileSize)
                || detectCollision(reckRev.getX(), reckRev.getY(), (tileSize * 2), tileSize)
                || detectCollision(bike.getX(), bike.getY(), tileSize, tileSize)
                || detectCollision(bikeRev.getX(), bikeRev.getY(), tileSize, tileSize)
                || detectCollision(stinger.getX(), stinger.getY(), (tileSize * 3), tileSize)) {
            playerLives.setCount(playerLives.getCount() - 1);
            lives.setText("Lives: " + playerLives.getCount());
            Util.resetPosition(player, playerPOS);
            playerScore.setValue(0);
            scoreDisplay.setText("" + playerScore.getValue());
        }
    }
}

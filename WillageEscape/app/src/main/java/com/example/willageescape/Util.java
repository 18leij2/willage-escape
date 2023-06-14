package com.example.willageescape;

import android.widget.ImageView;
import android.widget.TextView;

public class Util {
    private static int startingX;
    private static int startingY;

    public static void setStartingX(int x) {
        startingX = x;
    }

    public static void setStartingY(int y) {
        startingY = y;
    }

    public static int getStartingX() {
        return startingX;
    }

    public static int getStartingY() {
        return startingY;
    }

    public static float moveLeft(ImageView player, int amount, Position playerPOS) {
        float newPosition = player.getX() - amount;
        if (newPosition < 0) {
            System.out.println("Out of bounds");
            return 0;
        } else {
            playerPOS.setX(playerPOS.getX() - 1);
            return newPosition;
        }
    }

    public static float moveRight(ImageView player, int tileDimension, int screenwidth,
                                  Position playerPOS) {
        float newPosition = player.getX() + tileDimension;
        if (newPosition + tileDimension - 1 > screenwidth) {
            System.out.println("Out of bounds");
            return player.getX();
        } else {
            playerPOS.setX(playerPOS.getX() + 1);
            return newPosition;
        }
    }

    public static float moveDown(ImageView player, int tileDimension, int lowerBound,
                                 Position playerPOS) {
        float newPosition = player.getY() + tileDimension;
        if (newPosition + tileDimension - 1 > (float) lowerBound) {
            System.out.println("Out of bounds");
            return player.getY();
        } else {
            playerPOS.setY(playerPOS.getY() + 1);
            return newPosition;
        }
    }

    public static float moveUp(ImageView player, int tileDimension, int upperBound,
                               Position playerPOS) {
        float newPosition = player.getY() - tileDimension;
        if (newPosition < (float) upperBound) {
            System.out.println("Out of bounds");
            return player.getY();
        } else {
            playerPOS.setY(playerPOS.getY() - 1);
            return newPosition;
        }
    }

    public static void updateScoreIfValidUp(ImageView player, Score score, Position playerPOS) {
        if (player.getY() < score.getMinPlayerY()) {
            score.setMinPlayerY(player.getY());
            if (playerPOS.getY() == 13 || playerPOS.getY() == 10) {
                score.setValue(score.getValue() + 3);
            } else if (playerPOS.getY() == 12 || playerPOS.getY() == 9) {
                score.setValue(score.getValue() + 2);
            } else if (playerPOS.getY() == 11) {
                score.setValue(score.getValue() + 4);
            } else if (playerPOS.getY() <= 7 && playerPOS.getY() >= 2) {
                score.setValue(score.getValue() + 3);
            } else if (playerPOS.getY() < 2) {
                score.setValue(score.getValue() + 65);
            } else {
                score.setValue(score.getValue() + 1);
            }
        }
    }

    public static void updateScoreIfStepInWater(ImageView player, Score score, TextView lives,
                                                Lives playerLives, Position playerPOS,
                                                boolean isLogged, boolean killPlayer) {
        if ((playerPOS.getY() <= 8 && playerPOS.getY() >= 3 && !isLogged) || killPlayer) {
            System.out.println("here");
            playerLives.setCount(playerLives.getCount() - 1);
            lives.setText("Lives: " + playerLives.getCount());
            score.setValue(0);


            resetPosition(player, playerPOS);

            if (playerLives.getCount() == 0) {
                System.out.println("GAME OVER");
            }
        }

    }

    public static void resetPosition(ImageView player, Position playerPOS) {
        player.setX(startingX);
        player.setY(startingY);
        playerPOS.setY(16);
        playerPOS.setX(5);
    }
}

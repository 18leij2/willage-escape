package com.example.willageescape;

public class Score {
    private int value;
    private float minPlayerY;

    public Score(int value, float minPlayerY) {
        this.value = value;
        this.minPlayerY = minPlayerY;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setMinPlayerY(float minPlayerY) {
        this.minPlayerY = minPlayerY;
    }

    public float getMinPlayerY() {
        return minPlayerY;
    }

    public int getValue() {
        return value;
    }
}

package com.example.willageescape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.widget.ImageView;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class MainActivityTest {
    @Test
    public void testMoveLeftWhenAtLeftBoundary() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(0f);
        Position player = new Position(0, 0);

        // 2. call function we want to test
        float result = Util.moveLeft(mockedPlayer, 10, player);

        // 3. verify results
        assertEquals(result, 0, 0.000000001);
    }

    @Test
    public void testMoveLeftWhenNotAtLeftBoundary() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Position player = new Position(0, 0);

        // 2. call function we want to test
        float result = Util.moveLeft(mockedPlayer, 10, player);

        // 3. verify results
        assertEquals(result, 40, 0.000000001);
    }

}



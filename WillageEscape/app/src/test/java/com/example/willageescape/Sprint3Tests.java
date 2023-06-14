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
public class Sprint3Tests {

    //NOTE
    //SafeTile are on 15, 9
    //RoadTiles are from 10 to 14
    //RiverTiles are from 3 to 8


    @Test
    public void testMoveLeftWhenOnSafe() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        ImageView mockedPlayer2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer2.getX()).thenReturn(0f); //some arbitrary x value
        Mockito.when(mockedPlayer2.getY()).thenReturn(150f);
        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 16);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 100);
        Score score2 = new Score(0, 100);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);
        Util.updateScoreIfValidUp(mockedPlayer2, score2, player);

        // 3. verify results- there should be no change when player moves left
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 100, 0.000000001);
        assertEquals(score2.getValue(), 0);
        assertEquals(score2.getMinPlayerY(), 100, 0.000000001);
    }

    @Test
    public void testMoveUpWhenOnSafeAndIncreaseScore() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(50f); //player has moved below the
        //score's minPlayerY, thus the score should increase

        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 16);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 100);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);

        // 3. verify results- there should be increase in score
        assertEquals(score.getValue(), 1);
        assertEquals(score.getMinPlayerY(), 50, 0.000000001);
    }

    @Test
    public void testMoveUpWhenOnSafeAndNotIncreaseScore() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(150f); // player has not moved above the
        //minPlayerY value

        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 16);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 100);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);

        // 3. verify results- there shouldn't be increase in score
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 100, 0.000000001);
    }

    //NOTE
    //SafeTile are on 15, 9 (+ 1)
    //RoadTiles are from 10 to 14 (+ 2)
    //RiverTiles are from 3 to 8 (+ 3)
    @Test
    public void testMoveDownWhenOnSafeAndNotIncreaseScore() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(100f); //player has moved below the
        //score's minPlayerY, thus the score should increase

        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 16);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 50);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);

        // 3. verify results- the score stays the same
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 50, 0.000000001);
    }
    @Test
    public void testMoveRightWhenOnSafe() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(0f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        ImageView mockedPlayer2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer2.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer2.getY()).thenReturn(150f);
        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 16);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 50);
        Score score2 = new Score(0, 50);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);
        Util.updateScoreIfValidUp(mockedPlayer2, score2, player);

        // 3. verify results- there should be no change when player moves right
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 50, 0.000000001);
        assertEquals(score2.getValue(), 0);
        assertEquals(score2.getMinPlayerY(), 50, 0.000000001);
    }

    @Test
    public void testMoveLeftWhenOnRoad() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        ImageView mockedPlayer2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer2.getX()).thenReturn(0f); //some arbitrary x value
        Mockito.when(mockedPlayer2.getY()).thenReturn(150f);
        //player is in road
        Position player = new Position(5, 10);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 100);
        Score score2 = new Score(0, 100);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);
        Util.updateScoreIfValidUp(mockedPlayer2, score2, player);

        // 3. verify results- there should be no change when player moves left
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 100, 0.000000001);
        assertEquals(score2.getValue(), 0);
        assertEquals(score2.getMinPlayerY(), 100, 0.000000001);
    }

    @Test
    public void testMoveUpWhenOnRoadAndIncreaseScore() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(50f); //player has moved below the
        //score's minPlayerY, thus the score should increase

        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 10);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 100);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);

        // 3. verify results- there should be increase in score
        assertEquals(score.getValue(), 2);
        assertEquals(score.getMinPlayerY(), 50, 0.000000001);
    }

    @Test
    public void testMoveUpWhenOnRoadAndNotIncreaseScore() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(150f); // player has not moved above the
        //minPlayerY value

        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 16);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 100);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);

        // 3. verify results- there should be increase in score
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 100, 0.000000001);
    }
    @Test
    public void testMoveLeftWhenOnRiver() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        ImageView mockedPlayer2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer2.getX()).thenReturn(0f); //some arbitrary x value
        Mockito.when(mockedPlayer2.getY()).thenReturn(150f);
        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 8);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 100);
        Score score2 = new Score(0, 100);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);
        Util.updateScoreIfValidUp(mockedPlayer2, score2, player);

        // 3. verify results- there should be no change when player moves left
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 100, 0.000000001);
        assertEquals(score2.getValue(), 0);
        assertEquals(score2.getMinPlayerY(), 100, 0.000000001);
    }

    @Test
    public void testMoveUpWhenOnRiverAndIncreaseScore() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(50f); //player has moved below the
        //score's minPlayerY, thus the score should increase

        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 8);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 100);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);

        // 3. verify results- there should be increase in score
        assertEquals(score.getValue(), 3);
        assertEquals(score.getMinPlayerY(), 50, 0.000000001);
    }

    @Test
    public void testMoveUpWhenOnRiverAndNotIncreaseScore() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(150f); // player has not moved above the
        //minPlayerY value

        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 8);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 100);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);

        // 3. verify results- there should be increase in score
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 100, 0.000000001);
    }

    @Test
    public void testMoveDownWhenOnRoadAndNotIncreaseScore() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(100f); //player has moved below the
        //score's minPlayerY, thus the score should increase

        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 10);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 50);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);

        // 3. verify results- the score stays the same
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 50, 0.000000001);
    }
    @Test
    public void testMoveRightWhenOnRoad() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(0f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        ImageView mockedPlayer2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer2.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer2.getY()).thenReturn(150f);
        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 10);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 50);
        Score score2 = new Score(0, 50);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);
        Util.updateScoreIfValidUp(mockedPlayer2, score2, player);

        // 3. verify results- there should be no change when player moves right
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 50, 0.000000001);
        assertEquals(score2.getValue(), 0);
        assertEquals(score2.getMinPlayerY(), 50, 0.000000001);
    }

    @Test
    public void testMoveRightWhenOnRiverAndNotIncreaseScore() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(150f); // player has not moved above the
        //minPlayerY value

        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 8);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 50);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);

        // 3. verify results- there should be no increase in score
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 50, 0.000000001);
    }

    @Test
    public void testMoveDownWhenOnRiverAndNotIncreaseScore() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f); //some arbitrary x value
        Mockito.when(mockedPlayer.getY()).thenReturn(150f); // player has not moved above the
        //minPlayerY value

        //player is in initial starting position (at bottom of screen)
        Position player = new Position(5, 8);

        //value is the starting score, minPlayerY is the value of the Y position of the player has
        //to be smaller than for the score to increase
        Score score = new Score(0, 50);

        // 2. call function we want to test
        Util.updateScoreIfValidUp(mockedPlayer, score, player);

        // 3. verify results- there should be increase in score
        assertEquals(score.getValue(), 0);
        assertEquals(score.getMinPlayerY(), 50, 0.000000001);
    }

}



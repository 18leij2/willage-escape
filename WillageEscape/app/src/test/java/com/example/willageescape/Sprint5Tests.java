package com.example.willageescape;

import static org.junit.Assert.assertEquals;

import android.widget.ImageView;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class Sprint5Tests {

    //NOTE
    //SafeTile are on 15, 9
    //RoadTiles are from 10 to 14
    //RiverTiles are from 3 to 8

    //Vehicles on each road:
    //road 1 = reck
    //road 2 = bikeRev
    //road 3 = stinger
    //road 4 = reckRev
    //road 5 = bike
    @Test
    public void testSmallLog1_positionMoveWithLog() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should move together
        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(50f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(150f);

        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(0f);
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(0f);
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(0f);
        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(0f);
        Mockito.when(mockedlargelog.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test
        c.checkForCollision(logs, playerLives, playerScore, mockedScoreDisplay, playerPOS);

        // 3. verify results- player position should be moving with log
        assertEquals(5, playerPOS.getX());
        assertEquals(16, playerPOS.getY());

    }

    @Test
    public void testMoveOffScreenWithSmallLog1_livesDecrease() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they move together
        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(50f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(150f);

        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(0f);
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(0f);
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(0f);
        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(0f);
        Mockito.when(mockedlargelog.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);

        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test
        c.checkForCollision(logs, playerLives, playerScore, mockedScoreDisplay, playerPOS);

        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(2, playerLives.getCount());

    }

    @Test
    public void testSmallLog2_positionMoveWithLog() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should move together
        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(50f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(150f);

        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(0f);
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(0f);
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(0f);
        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(0f);
        Mockito.when(mockedlargelog.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test
        c.checkForCollision(logs, playerLives, playerScore, mockedScoreDisplay, playerPOS);

        // 3. verify results- player position should be moving with log
        assertEquals(5, playerPOS.getX());
        assertEquals(16, playerPOS.getY());

    }

    @Test
    public void testMoveOffScreenWithSmallLog2_livesDecrease() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they move together
        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(50f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(150f);

        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(0f);
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(0f);
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(0f);
        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(0f);
        Mockito.when(mockedlargelog.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);

        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test
        c.checkForCollision(logs, playerLives, playerScore, mockedScoreDisplay, playerPOS);

        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(2, playerLives.getCount());

    }

    @Test
    public void testSmallLog3_positionMoveWithLog() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should move together
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(50f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(150f);

        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(0f);
        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(0f);
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(0f);
        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(0f);
        Mockito.when(mockedlargelog.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test
        c.checkForCollision(logs, playerLives, playerScore, mockedScoreDisplay, playerPOS);

        // 3. verify results- player position should be moving with log
        assertEquals(5, playerPOS.getX());
        assertEquals(16, playerPOS.getY());

    }

    @Test
    public void testMoveOffScreenWithSmallLog3_livesDecrease() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they move together
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(50f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(150f);

        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(0f);
        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(0f);
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(0f);
        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(0f);
        Mockito.when(mockedlargelog.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);

        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test
        c.checkForCollision(logs, playerLives, playerScore, mockedScoreDisplay, playerPOS);

        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(2, playerLives.getCount());

    }

    @Test
    public void testSmallLog4_positionMoveWithLog() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should move together
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(50f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(150f);

        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(0f);
        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(0f);
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(0f);
        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(0f);
        Mockito.when(mockedlargelog.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test
        c.checkForCollision(logs, playerLives, playerScore, mockedScoreDisplay, playerPOS);

        // 3. verify results- player position should be moving with log
        assertEquals(5, playerPOS.getX());
        assertEquals(16, playerPOS.getY());

    }
    @Test
    public void testMoveOffScreenWithSmallLog4_livesDecrease() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they move together
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(50f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(150f);

        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(0f);
        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(0f);
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(0f);
        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(0f);
        Mockito.when(mockedlargelog.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);

        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test
        c.checkForCollision(logs, playerLives, playerScore, mockedScoreDisplay, playerPOS);

        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(2, playerLives.getCount());

    }
    @Test
    public void testLargeLog_positionMoveWithLog() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should move together
        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(50f);
        Mockito.when(mockedlargelog.getY()).thenReturn(150f);

        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(0f);
        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(0f);
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(0f);
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test
        c.checkForCollision(logs, playerLives, playerScore, mockedScoreDisplay, playerPOS);

        // 3. verify results- player position should be moving with log
        assertEquals(5, playerPOS.getX());
        assertEquals(16, playerPOS.getY());

    }
    @Test
    public void testMoveOffScreenWithLargeLog_livesDecrease() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they move together
        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(50f);
        Mockito.when(mockedlargelog.getY()).thenReturn(150f);

        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(0f);
        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(0f);
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(0f);
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);

        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test
        c.checkForCollision(logs, playerLives, playerScore, mockedScoreDisplay, playerPOS);

        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(2, playerLives.getCount());

    }
    @Test
    public void testLilyPad_livesNotDecrease() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they move together
        ImageView mockedlily1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedlily1.getX()).thenReturn(50f);
        Mockito.when(mockedlily1.getY()).thenReturn(150f);

        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(50f);
        Mockito.when(mockedlargelog.getY()).thenReturn(150f);
        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(0f);
        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(0f);
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(0f);
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);

        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(3, playerLives.getCount());

    }
    @Test
    public void testLilyPad2_livesNotDecrease() {
        // 1. setup
        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they move together
        ImageView mockedlily2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedlily2.getX()).thenReturn(50f);
        Mockito.when(mockedlily2.getY()).thenReturn(150f);

        ImageView mockedlargelog = Mockito.mock(ImageView.class);
        Mockito.when(mockedlargelog.getX()).thenReturn(50f);
        Mockito.when(mockedlargelog.getY()).thenReturn(150f);
        ImageView mockedsmalllog1 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog1.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog1.getY()).thenReturn(0f);
        ImageView mockedsmalllog2 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog2.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog2.getY()).thenReturn(0f);
        ImageView mockedsmalllog3 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog3.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog3.getY()).thenReturn(0f);
        ImageView mockedsmalllog4 = Mockito.mock(ImageView.class);
        Mockito.when(mockedsmalllog4.getX()).thenReturn(0f);
        Mockito.when(mockedsmalllog4.getY()).thenReturn(0f);

        List<ImageView> logs = new ArrayList<>();
        logs.add(mockedsmalllog1);
        logs.add(mockedsmalllog2);
        logs.add(mockedsmalllog3);
        logs.add(mockedsmalllog4);
        logs.add(mockedlargelog);

        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(3, playerLives.getCount());

    }
}



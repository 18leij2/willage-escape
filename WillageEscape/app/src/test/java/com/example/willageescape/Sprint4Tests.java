package com.example.willageescape;

import static org.junit.Assert.assertEquals;

import android.widget.ImageView;
import android.widget.TextView;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class Sprint4Tests {

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
    public void testCollisionWithReck_positionReset() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(50f);
        Mockito.when(mockedReck.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player position should be 5, 16
        // which is always the initial starting position
        assertEquals(5, playerPOS.getX());
        assertEquals(16, playerPOS.getY());

    }

    @Test
    public void testCollisionWithReck_scoreReset() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(50f);
        Mockito.when(mockedReck.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player score should be reset to 0
        assertEquals(0, playerScore.getValue());

    }

    @Test
    public void testCollisionWithReck_livesDecrease() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(50f);
        Mockito.when(mockedReck.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(2, playerLives.getCount());

    }
    @Test
    public void testCollisionWithStinger_positionReset() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(50f);
        Mockito.when(mockedStinger.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player position should be 5, 16
        // which is always the initial starting position
        assertEquals(5, playerPOS.getX());
        assertEquals(16, playerPOS.getY());

    }

    @Test
    public void testCollisionWithStinger_scoreReset() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(50f);
        Mockito.when(mockedStinger.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player score should be reset to 0
        assertEquals(0, playerScore.getValue());

    }

    @Test
    public void testCollisionWithStinger_livesDecrease() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(50f);
        Mockito.when(mockedStinger.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(2, playerLives.getCount());

    }

    @Test
    public void testCollisionWithBike_positionReset() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(50f);
        Mockito.when(mockedBike.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player position should be 5, 16
        // which is always the initial starting position
        assertEquals(5, playerPOS.getX());
        assertEquals(16, playerPOS.getY());

    }

    @Test
    public void testCollisionWithBike_scoreReset() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(50f);
        Mockito.when(mockedBike.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player score should be reset to 0
        assertEquals(0, playerScore.getValue());

    }

    @Test
    public void testCollisionWithBike_livesDecrease() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(50f);
        Mockito.when(mockedBike.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(2, playerLives.getCount());

    }
    @Test
    public void testCollisionWithRevReck_positionReset() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(50f);
        Mockito.when(mockedRevReck.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player position should be 5, 16
        // which is always the initial starting position
        assertEquals(5, playerPOS.getX());
        assertEquals(16, playerPOS.getY());

    }
    @Test
    public void testCollisionWithRevReck_scoreReset() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(50f);
        Mockito.when(mockedRevReck.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player score should be reset to 0
        assertEquals(0, playerScore.getValue());

    }
    @Test
    public void testCollisionWithRevReck_livesDecrease() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(50f);
        Mockito.when(mockedRevReck.getY()).thenReturn(150f);

        // other vehicles are not in the same position

        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(0f);
        Mockito.when(mockedRevBike.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(2, playerLives.getCount());

    }

    @Test
    public void testCollisionWithBikeRev_positionReset() {
        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(50f);
        Mockito.when(mockedRevBike.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player position should be 5, 16
        // which is always the initial starting position
        assertEquals(5, playerPOS.getX());
        assertEquals(16, playerPOS.getY());

    }
    @Test
    public void testCollisionWithBikeRev_scoreReset() {
        // 1. setup

        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(50f);
        Mockito.when(mockedRevBike.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player score should be reset to 0
        assertEquals(0, playerScore.getValue());

    }
    @Test
    public void testCollisionWithBikeRev_livesDecrease() {
        // 1. setup

        // 1. setup

        ImageView mockedPlayer = Mockito.mock(ImageView.class);
        Mockito.when(mockedPlayer.getX()).thenReturn(50f);
        Mockito.when(mockedPlayer.getY()).thenReturn(150f);
        TextView mockedScoreDisplay = Mockito.mock(TextView.class);
        TextView mockedLivesDisplay = Mockito.mock(TextView.class);

        // they are at the same position, so they should collide
        ImageView mockedRevBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevBike.getX()).thenReturn(50f);
        Mockito.when(mockedRevBike.getY()).thenReturn(150f);

        // other vehicles are not in the same position
        ImageView mockedRevReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedRevReck.getX()).thenReturn(0f);
        Mockito.when(mockedRevReck.getY()).thenReturn(0f);
        ImageView mockedBike = Mockito.mock(ImageView.class);
        Mockito.when(mockedBike.getX()).thenReturn(0f);
        Mockito.when(mockedBike.getY()).thenReturn(0f);
        ImageView mockedStinger = Mockito.mock(ImageView.class);
        Mockito.when(mockedStinger.getX()).thenReturn(0f);
        Mockito.when(mockedStinger.getY()).thenReturn(0f);
        ImageView mockedReck = Mockito.mock(ImageView.class);
        Mockito.when(mockedReck.getX()).thenReturn(0f);
        Mockito.when(mockedReck.getY()).thenReturn(0f);


        List<ImageView> vehicles = new ArrayList<>();
        vehicles.add(mockedReck);
        vehicles.add(mockedRevReck);
        vehicles.add(mockedBike);
        vehicles.add(mockedRevBike);
        vehicles.add(mockedStinger);


        //player is in initial starting position (at bottom of screen)
        Position playerPOS = new Position(5, 10);
        //player lives is set to 3
        Lives playerLives = new Lives(3);
        //player score is set to 10
        Score playerScore = new Score(10, 0); //minPlayerY can be set to arbitrary value

        Collision c = new Collision(50, mockedPlayer, mockedLivesDisplay);

        // 2. call function we want to test

        c.checkForCollision(vehicles, playerLives, playerScore, mockedScoreDisplay, playerPOS);


        // 3. verify results- player lives should decrease by 1, from 3 to 2
        assertEquals(2, playerLives.getCount());

    }

}



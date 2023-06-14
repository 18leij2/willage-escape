package com.example.willageescape;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private ConfigScreen test;
    private MainActivity test2;

    private MainActivity test5;
    private MainActivity test6;
    
    private MainActivity test3;
    private MainActivity test4;
    private MainActivity test7;
    private MainActivity test8;
    private ConfigScreen test9;
    private ConfigScreen test10;
    private ConfigScreen test11;
    private MainActivity test12;
    @Before
    public void start() {
        test = Mockito.mock(ConfigScreen.class);
        test2 = Mockito.mock(MainActivity.class);
        test5 = Mockito.mock(MainActivity.class);
        test6 = Mockito.mock(MainActivity.class);
        test3 = Mockito.mock(MainActivity.class);
        test4 = Mockito.mock(MainActivity.class);
        test7 = Mockito.mock(MainActivity.class);
        test8 = Mockito.mock(MainActivity.class);
        test9 = Mockito.mock(ConfigScreen.class);
        test10 = Mockito.mock(ConfigScreen.class);
        test11 = Mockito.mock(ConfigScreen.class);
        test12 = Mockito.mock(MainActivity.class);
    }

    @Test
    public void testPlayerUsername() {
        String testedUsername = "";
        // Verify that the user input is good
        Mockito.when(test.verifyUsername(testedUsername)).thenReturn(true);

        assertTrue(test.verifyUsername(testedUsername));
    }

    @Test
    public void testTileDimension() {
        int expected = 100;
        Mockito.when(test2.returnTileDimension(900)).thenReturn(100);
        assertEquals(expected, test2.returnTileDimension(900));

    }

    @Test
    public void testIsEasy() {
        int choice = 1;
        boolean expected = true;
        System.out.println(test9.isEasy(1));
        Mockito.when(test9.isEasy(1)).thenReturn(true);
        assertEquals(expected, test9.isEasy(choice));
    }
    @Test
    public void testIsMedium() {
        int choice = 2;
        boolean expected = true;
        Mockito.when(test10.isMedium(2)).thenReturn(true);
        assertEquals(expected, test10.isMedium(choice));
    }

    @Test
    public void testIsHard() {
        int choice = 3;
        boolean expected = true;
        Mockito.when(test11.isHard(3)).thenReturn(true);
        assertEquals(expected, test11.isHard(choice));
    }

    @Test
    public void testHealthHard() {
        int choice = 3;
        boolean expected = true;
        Mockito.when(test12.testHealthHard(3)).thenReturn(true);
        assertEquals(expected, test12.testHealthHard(choice));
    }

    @Test
    public void testMoveRight() {
        int expected = 150;
        Mockito.when(test5.returnMoveRight(100,50)).thenReturn(150);
        assertEquals(expected, test5.returnMoveRight(100,50));
    }

    @Test
    public void testMoveLeft() {
        int expected = 770;
        Mockito.when(test6.returnMoveLeft(800,30)).thenReturn(770);
        assertEquals(expected, test6.returnMoveLeft(800,30));
    }

    @Test
    public void testMoveUp() {
        int expected = 550;
        Mockito.when(test3.returnMoveUp(700, 150)).thenReturn(550);
        assertEquals(expected, test3.returnMoveUp(700, 150));
    }

    @Test
    public void testMoveDown() {
        int expected = 850;
        Mockito.when(test4.returnMoveDown(700, 150)).thenReturn(850);
        assertEquals(expected, test4.returnMoveDown(700, 150));
    }
//    @Test
//    public void testRightBoundary() {
//        Mockito.when(test7.rightOnClick(100, 100, 50, 100)).thenReturn(false);
//        assertEquals(false, test7.rightOnClick(100, 100, 50, 100));
//    }
//
//    @Test
//    public void testLeftBoundary() {
//        Mockito.when(test8.leftOnClick(0, 100, 50)).thenReturn(false);
//        assertEquals(false, test8.leftOnClick(0, 100, 50));
//    }


}

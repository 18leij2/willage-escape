package com.example.willageescape;

public class GameLoop extends Thread {
    private MainActivity mainActivity;
    private boolean isRunning;
    private static final double MAX_UPS = 60.0;
    private static final double UPS_PERIOD = 1E+3 / MAX_UPS;
    private double averageUPS;
    private double averageFPS;
    public GameLoop(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void startLoop() {
        isRunning = true;
        start();
    }

    public void run() {
        super.run();

        int updateCount = 0;
        int frameCount = 0;

        long startTime;
        long elapsedTime;
        long sleepTime;

        startTime = System.currentTimeMillis();
        while (isRunning) {
            try {
                mainActivity.update(frameCount);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            updateCount++;
            frameCount++;

            elapsedTime = System.currentTimeMillis() - startTime;
            sleepTime = (long) (updateCount * UPS_PERIOD - elapsedTime);
            if (sleepTime > 0) {
                try {
                    sleep(sleepTime / 60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (frameCount > 1000000) {
                frameCount = 0;
            }

            //            elapsedTime = System.currentTimeMillis();
            //            if (elapsedTime >= 1000) {
            //                averageUPS = updateCount / (1E-3 * elapsedTime);
            //                averageFPS = frameCount / (1E-3 * elapsedTime);
            //                updateCount = 0;
            //                frameCount = 0;
            //                startTime = System.currentTimeMillis();
            //            }
        }
    }
}

package PA;

import java.io.IOException;

public class TrafficLight implements Runnable {
    private static final int GREEN_TIME = 10000; // 10 seconds
    private static final int YELLOW_TIME = 2000; // 2 seconds
    private static final int RED_TIME = 5000; // 5 seconds

    private String[] colors = {"green", "yellow", "red"};
    private int currentColorIndex = 0;
    private boolean stopped = false;

    @Override
    public void run() {
        try {
            while (!stopped) {
                switch (currentColorIndex) {
                    case 0:
                        System.out.println("green");
                        Thread.sleep(GREEN_TIME);
                        break;
                    case 1:
                        System.out.println("yellow");
                        Thread.sleep(YELLOW_TIME);
                        break;
                    case 2:
                        System.out.println("red");
                        Thread.sleep(RED_TIME);
                        break;
                }
                currentColorIndex = (currentColorIndex + 1) % colors.length;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        stopped = true;
    }

}

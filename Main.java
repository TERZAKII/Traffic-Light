package PA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        TrafficLight trafficLight = new TrafficLight();
        Thread trafficLightThread = new Thread(trafficLight);
        trafficLightThread.start();
        System.out.println("To stop the program, write \"stop\" key");
        System.out.println();
        InputListener inputListener = new InputListener(trafficLightThread);
        Thread inputThread = new Thread(inputListener);
        inputThread.start();

        trafficLightThread.join();
        inputThread.join();
    }

    private static class InputListener implements Runnable {
        private final Thread trafficLightThread;

        private InputListener(Thread trafficLightThread) {
            this.trafficLightThread = trafficLightThread;
        }

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    if (line.equals("stop")) {
                        trafficLightThread.interrupt();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



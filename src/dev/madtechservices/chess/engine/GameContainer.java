package dev.madtechservices.chess.engine;

public class GameContainer implements Runnable{

    private Thread thread;

    private boolean running = false;

    private final double FRAME_CAP = 1.0 / 120;

    public GameContainer() {

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.run();
    }

    public synchronized void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        running = true;

        double firstTime = 0, lastTime = 0, passedTime = 0, unProcessedTime = 0;

        while (running) {

        }
    }

    public void dispose() {

    }


}

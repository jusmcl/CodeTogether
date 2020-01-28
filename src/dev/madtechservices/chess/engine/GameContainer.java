package dev.madtechservices.chess.engine;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameContainer implements Runnable {

    private Thread thread;
    private Window window;
    private Renderer renderer;
    private Input input;
    private AbstractGame game;

    private boolean running = false;
    private final double FRAME_CAP = 1.0 / 60;
    private float scale = 1f;
    private int width = 384, height = 216;
    private String title;
    private short threadSleepT = 5;

    public GameContainer(AbstractGame game) {
        this.game = game;
    }

    public synchronized void start() {
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);
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
        boolean render = false;
        double firstTime = 0, lastTime = 0, passedTime = 0, unProcessedTime = 0;
        lastTime = System.nanoTime() / 1000000000.0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while (running) {
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;

            passedTime = firstTime - lastTime;
            lastTime = firstTime;
            unProcessedTime += passedTime;
            frameTime += passedTime;

            while(unProcessedTime >= FRAME_CAP){
                unProcessedTime -= FRAME_CAP;
                render = true;

                //TODO: Update game
                game.update(this, (float) FRAME_CAP);
                input.update();

                if(frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;

                    System.out.println("FPS: " + fps);
                }
            }

            if(render){
                renderer.clear();
                game.render(this, renderer);
                window.update();
                ++frames;

                try {
                    Thread.sleep(threadSleepT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(threadSleepT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        dispose();
    }

    public void dispose() {
        //TODO delete the game.
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Window getWindow() {
        return window;
    }

    public Input getInput() {
        return input;
    }
}

package dev.madtechservices.chess.engine;

public class GameContainer implements Runnable {

    private Thread thread;
    private Window window;
    private Renderer renderer;

    private boolean running = false;
    private final double FRAME_CAP = 1.0 / 60;

    private float scale = 1f;
    private int width = 384, height = 216;
    private String title;

    public GameContainer() {

    }

    public synchronized void start() {
        window = new Window(this);
        renderer = new Renderer(this);
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

                if(frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;

                    System.out.println("FPS: " + fps);
                }
            }

            if(render){
                renderer.clear();
                //TODO: render game

                window.update();
                ++frames;

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        dispose();
    }

    public void dispose() {

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
}

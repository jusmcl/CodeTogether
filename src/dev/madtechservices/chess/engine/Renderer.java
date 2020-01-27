package dev.madtechservices.chess.engine;

import java.awt.image.DataBufferInt;

public class Renderer {

    private int px_W, px_H;
    private int[] pixels;

    public Renderer(GameContainer gc) {
        px_W = gc.getWidth();
        px_H = gc.getHeight();
        pixels = ((DataBufferInt) gc.getWindow().getPixelData().getRaster().getDataBuffer()).getData();
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }
}

package dev.madtechservices.chess.engine;

import gfx.Image;

import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class Renderer {

    private int px_W, px_H;
    private int[] pixels;

    public Renderer(GameContainer gc) {
        px_W = gc.getWidth();
        px_H = gc.getHeight();
        pixels = ((DataBufferInt) gc.getWindow().getPixelData().getRaster().getDataBuffer()).getData();
    }

    //Set the screen to a single color and overwrite the pixel data.
    public void clear() {
        Arrays.fill(pixels, 0);
//        for (int i = 0; i < pixels.length; i++) {
//            pixels[i] += i;
//        }
    }

    public void setPixel(int x, int y, int value){
        if((x < 0 || x >= px_W || y < 0 || y >= px_H) || value == 0xffff00ff) {
            return;
        }

        pixels[x + y * px_W] = value;
    }

    public void drawImage(Image image, int offX, int offY){
        for(int y = 0; y < image.getH(); y++){
            for(int x = 0 ; x < image.getW(); x++){
                setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
            }
        }
    }
}

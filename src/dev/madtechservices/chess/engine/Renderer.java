package dev.madtechservices.chess.engine;

import dev.madtechservices.chess.engine.gfx.Image;

import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class Renderer {

    private int pix_W, pix_H;
    private int[] pixels;

    public Renderer(GameContainer gc) {
        pix_W = gc.getWidth();
        pix_H = gc.getHeight();
        pixels = ((DataBufferInt) gc.getWindow().getPixelData().getRaster().getDataBuffer()).getData();
    }

    //Set the screen to a single color and overwrite the pixel data.
    public void clear() {
        Arrays.fill(pixels, 0);
    }

    public void setPixel(int x, int y, int value){
        if((x < 0 || x >= pix_W || y < 0 || y >= pix_H) || value == 0xffff00ff) {
            return;
        }

        pixels[x + y * pix_W] = value;
    }

    public void drawImage(Image image, int offX, int offY) {


        //#Dont render code
        if(offX < -image.getW()) return;
        if(offY < -image.getH()) return;
        if(offX >= pix_W) { return; };
        if(offY >= pix_H) { return; };

        int newX = 0;
        int newY = 0;
        int newWidth = image.getW();
        int newHeight = image.getH();

        //Clipping code.
        if(offX < 0) { newX -= offX; }
        if(offY < 0) { newY -= offY; }
        if (newWidth + offX >= pix_W) {
            newWidth -= newWidth + offX - pix_W;
        }
        if (newHeight + offY >= pix_H){
            newHeight -= newHeight + offY - pix_H;
        }

        for(int y = newY; y < newHeight; y++){
            for(int x = newX ; x < newWidth; x++){
                setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
            }
        }
    }
}

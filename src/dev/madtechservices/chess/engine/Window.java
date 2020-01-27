package dev.madtechservices.chess.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window {

    private JFrame frame;
    private BufferedImage pixelData;
    private Canvas canvas;
    private Graphics gfx;
    private BufferStrategy bs;


    public Window(GameContainer gc) {
        pixelData = new BufferedImage(gc.getWidth(), gc.getHeight(), BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension d = new Dimension( (int) ( gc.getWidth() * gc.getScale() ) , (int) ( gc.getHeight() * gc.getScale() ) );

        canvas.setPreferredSize(d);
        canvas.setMaximumSize(d);
        canvas.setMinimumSize(d);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(3);
        bs = canvas.getBufferStrategy();
        gfx = bs.getDrawGraphics();
    }

    public void update() {
        gfx.drawImage(pixelData,0, 0, canvas.getWidth(), canvas.getHeight(), null);
        bs.show();
    }
}

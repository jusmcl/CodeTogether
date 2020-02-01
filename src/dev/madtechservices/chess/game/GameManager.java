package dev.madtechservices.chess.game;

import dev.madtechservices.chess.engine.AbstractGame;
import dev.madtechservices.chess.engine.GameContainer;
import dev.madtechservices.chess.engine.Renderer;
import dev.madtechservices.chess.engine.gfx.Image;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameManager extends AbstractGame {

    private Image image;

    public GameManager() {
        image = new Image("/CodeTogether/res/test.png");
    }

    @Override
    public void update(GameContainer gc, float dt) {

        // Keyboard input Testing
        if (gc.getInput().isKeyDown(KeyEvent.VK_E)) {
            System.out.println("E key is pressed.");
        }

        // Left mouse button input testing
        if(gc.getInput().isButtonDown(MouseEvent.BUTTON1)) {
            System.out.println("Left mouse button is down.");
        }

        // Middle mouse button input testing
        if(gc.getInput().isButtonDown(MouseEvent.BUTTON2)) {
            System.out.println("Middle mouse button is down.");
        }

        // Right mouse button input testing
        if(gc.getInput().isButtonDown(MouseEvent.BUTTON3)) {
            System.out.println("Right mouse button is down.");
        }
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImage(image, gc.getInput().getMouseX(), gc.getInput().getMouseY());
    }

    public static void main(String args[]) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}

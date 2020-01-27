package dev.madtechservices.chess.game;

import dev.madtechservices.chess.engine.AbstractGame;
import dev.madtechservices.chess.engine.GameContainer;
import dev.madtechservices.chess.engine.Renderer;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameManager extends AbstractGame {

    public GameManager() {

    }

    @Override
    public void update(GameContainer gc, float dt) {
        if (gc.getInput().isKeyDown(KeyEvent.VK_E)) {
            System.out.println("E key is pressed.");
        }

        if(gc.getInput().isButtonDown(MouseEvent.BUTTON1)) {
            System.out.println("Left mouse button is down.");
        }
    }

    @Override
    public void render(GameContainer gc, Renderer r) {

    }

    public static void main(String args[]) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}

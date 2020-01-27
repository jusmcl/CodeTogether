package dev.madtechservices.chess.game;

import dev.madtechservices.chess.engine.AbstractGame;
import dev.madtechservices.chess.engine.GameContainer;
import dev.madtechservices.chess.engine.Renderer;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    public GameManager() {

    }

    @Override
    public void update(GameContainer gc, float dt) {
        if (gc.getInput().isKeyDown(KeyEvent.VK_E)) {
            System.out.println("E was pressed.");
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

package dev.madtechservices.chess;

import dev.madtechservices.chess.engine.GameContainer;

public class ChessMain {

    private static GameContainer gameContainer;

    public static void main(String[] args){
         gameContainer = new GameContainer();
         gameContainer.start();
    }
}

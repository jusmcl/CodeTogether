package dev.madtechservices.chess;

import dev.madtechservices.chess.engine.AbstractGame;
import dev.madtechservices.chess.engine.GameContainer;
import dev.madtechservices.chess.engine.Renderer;

public class ChessMain {
    private static AbstractGame abstractGame;
    private  GameContainer gameContainer = new GameContainer(abstractGame);

}

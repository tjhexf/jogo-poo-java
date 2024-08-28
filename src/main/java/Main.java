import Items.Heroi;
import Logic.GameTerminal;
import Logic.Board;

import java.awt.*;
import java.io.IOException;


public class Main {
    public static GameTerminal game;
    public static void main(String[] args) throws IOException, FontFormatException {
        game = new GameTerminal();
        game.run();
    }
}

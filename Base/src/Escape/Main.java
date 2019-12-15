package Escape;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        JFrame frame = new JFrame("Game");
        Frame gameFrame = new Frame();
        frame.add(gameFrame);
        frame.pack();
        frame.setVisible(true);
    }//    THE TRUE MAIN
}

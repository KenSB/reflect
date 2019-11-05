package Reflect.Entities;

import Reflect.States.Level;

import javax.swing.*;
import java.awt.*;

public class Wall extends Entity {
    public Wall(int xPos, int yPos, Level level) {
        super(xPos, yPos, level, false);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.darkGray);
        g.fill3DRect(xGrid*dimension, yGrid*dimension, 50, 50, true);
    }

    @Override
    public boolean collision(int direction, int distance) {
        return false;
    }

    @Override
    public void move(int direction, int distance) {

    }
    @Override
    public void animate(int direction, int distance) {

    }
}

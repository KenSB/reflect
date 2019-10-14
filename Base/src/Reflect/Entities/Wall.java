package Reflect.Entities;

import Reflect.States.State;

import java.awt.*;

public class Wall extends Entity {
    public Wall(int xPos, int yPos, State stage) {
        super(xPos, yPos, stage);
    }

    @Override
    public boolean collision(int direction) {
        return false;
    }
    @Override
    public void move(int direction) {}
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fill3DRect(xPos*dimension, yPos*dimension, 50, 50, true);
    }
    @Override
    public void animate() { }
}

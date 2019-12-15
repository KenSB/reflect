package Escape.Entities;

import Escape.States.Level;

import java.awt.*;

public class Box extends Entity implements Animatable{

    public Box(int xGrid, int yGrid, Level level) {
        super(xGrid, yGrid, level, true);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        if(animate) {
            g.fill3DRect(xDraw, yDraw, 50, 50, true);
        }
        else{
            g.fill3DRect(xGrid*dimension, yGrid*dimension, 50, 50, true);
        }
    }

    @Override
    public void animate(int direction, int distance) {
        movingDistance = distance;
        animate = true;
    }
}

package Escape.Entities;
import Escape.States.Level;

import java.awt.*;

public class Light extends Entity{

    Source source;
    public Light(int xGrid, int yGrid, Level level, Source source) {
        super(xGrid, yGrid, level, false);
        this.source = source;
    }

    @Override
    public boolean collision(int direction, int distance) {
        return false;
    }

    @Override
    public void move(int direction, int distance) {
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fill3DRect(xGrid*dimension, yGrid*dimension, 50, 50, true);
    }

    @Override
    public void animate(int direction, int distance) {

    }
}

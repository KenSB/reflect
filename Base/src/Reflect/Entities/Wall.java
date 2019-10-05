package Reflect.Entities;

import java.awt.*;

public class Wall extends Entity {
    public Wall(int xPos, int yPos) {
        super(xPos, yPos);
    }

    @Override
    public void collision() {}
    @Override
    public void move() {}
    @Override
    public void draw(Graphics g) { }
    @Override
    public void animate() { }
}

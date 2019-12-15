package Escape.Entities;
import Escape.States.Level;

import java.awt.*;

public class LightSwitch extends Entity implements Interactable{
    Interactable entity;

    public LightSwitch(int xGrid, int yGrid, Level level) {
        super(xGrid, yGrid, level, false);
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void animate(int direction, int distance) {

    }

    @Override
    public void interact() {


    }
    @Override
    public void update() {

    }
}

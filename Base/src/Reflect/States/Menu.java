package Reflect.States;

import Reflect.Entities.Entity;

import java.awt.*;

public class Menu extends State{
    public Menu(String name) {
        super(name + " Menu");
    }

    @Override
    public void keyPressed(int key) {}
    @Override
    public void draw(Graphics g) {}
}

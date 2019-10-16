package Reflect.States;

import Reflect.Entities.Entity;

import javax.swing.*;
import java.awt.*;

public class Menu extends State{
    public Menu(String name, JPanel frame) {
        super(name + " Menu", frame);
    }

    @Override
    public void keyPressed(int key) {}


    @Override
    public void draw(Graphics g) {

    }
}

package Reflect.States;
import Reflect.Drawable;


import javax.swing.*;
import java.awt.*;


public abstract class State implements Drawable{
    protected String name;
    public JPanel frame;
    public State(String name, JPanel frame){
        this.name = name;
        this.frame = frame;
    }
    public String getName() {
        return name;
    }
    public abstract void keyPressed(int key);
    public abstract void draw(Graphics g);
}

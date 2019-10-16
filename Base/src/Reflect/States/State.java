package Reflect.States;
import Reflect.Drawable;
import Reflect.Entities.Entity;
import Reflect.Entities.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class State implements Drawable{
    protected String name;
    protected ArrayList<Entity> entities = new ArrayList<>();
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
    public Iterator getEntitiesIterator(){
        return entities.iterator();
    }
}

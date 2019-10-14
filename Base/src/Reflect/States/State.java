package Reflect.States;
import Reflect.Drawable;
import Reflect.Entities.Entity;
import Reflect.Entities.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class State implements Drawable{
    protected String name;
    protected ArrayList<Entity> entities = new ArrayList<>();
    public State(String name){
        this.name = name;
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

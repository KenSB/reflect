package Reflect.States;
import Reflect.Drawable;
import Reflect.Entities.Entity;
import Reflect.Entities.Player;

import java.awt.*;
import java.util.ArrayList;

public abstract class State implements Drawable{
    protected String name;
    protected ArrayList<Entity> entities = new ArrayList<>();
    public State(String name){
        this.name = name;
    }
    public abstract void draw(Graphics g);
    public String getName(){return name;}

}

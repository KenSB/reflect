package Reflect.States;

import Reflect.Entities.Entity;

import java.awt.*;
import java.util.ArrayList;

public class Level extends State{
    private int [][] grid = new int[500][500];
    private ArrayList<Entity> entities = new ArrayList<>();
    public Level(String name){
        super(name);
    }

    @Override
    public void draw(Graphics g) {
        for(Entity entity : entities){
            entity.draw(g);
        }
    }
    public void addEntity(Entity entity){
        entities.add(entity);
    }
}

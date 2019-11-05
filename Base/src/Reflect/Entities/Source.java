package Reflect.Entities;

import Reflect.States.Level;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

public class Source extends Entity implements Interactable{
    private int direction;
    private boolean status = false;
    ArrayList <Light> beam = new ArrayList<>();
    private Mirror mirrorHit;

    public Source(int xGrid, int yGrid, Level level, int direction, boolean animate) {
        super(xGrid, yGrid, level, animate);
        this.direction = direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    public void setStatus(boolean status){
        this.status = status;
        if(status) {
            turnOn();
        }
        else
            turnOff();
    }
    public boolean getStatus(){
        return status;
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
        g.setColor(Color.GREEN);
        g.fill3DRect(xGrid*dimension, yGrid*dimension, 50, 50, true);


    }

    @Override
    public void animate(int direction, int distance) {
    }

    public void turnOff(){
        for(Light light: beam)
            level.remover(light);
        if(mirrorHit != null) {
            mirrorHit.turnOff();
            mirrorHit.setIsReflecting(false);
            mirrorHit = null;
        }
    }

    void turnOn(){
        Optional<Entity> entity;
        Light l;
        int i = 1;
        boolean blocked = false;
        System.out.println(direction);
        while(!blocked) {
            if (direction == UP) {
                entity = level.getEntity(xGrid, yGrid - i);
                if(entity == null || entity.get() instanceof Light) {
                    l = new Light(xGrid, yGrid - i, level, this);
                    beam.add(l);
                    level.spawner(l);
                }
                else if (entity.get() instanceof Mirror) {
                   if(((Mirror)entity.get()).mirrorShine(DOWN))
                       mirrorHit = (Mirror) entity.get();
                   blocked = true;
                }
                else
                    blocked = true;
            }
            else if (direction == DOWN) {
                entity = level.getEntity(xGrid, yGrid + i);
                if(entity == null || entity.get() instanceof Light) {
                    l = new Light(xGrid, yGrid + i, level, this);
                    beam.add(l);
                    level.spawner(l);
                }
                else if (entity.get() instanceof Mirror){
                    if(((Mirror)entity.get()).mirrorShine(UP))
                        mirrorHit = (Mirror) entity.get();
                    blocked = true;
                }
                else
                    blocked = true;
            }
            else if (direction == RIGHT) {
                entity = level.getEntity(xGrid + i, yGrid);
                if(entity == null || entity.get() instanceof Light) {
                    l = new Light(xGrid + i, yGrid, level, this);
                    beam.add(l);
                    level.spawner(l);
                }
                else if (entity.get() instanceof Mirror) {
                    if(((Mirror)entity.get()).mirrorShine(LEFT))
                        mirrorHit = (Mirror) entity.get();
                    blocked = true;
                }
                else
                    blocked = true;
            }
            else if (direction == LEFT) {
                entity = level.getEntity(xGrid - i, yGrid);
                if(entity == null || entity.get() instanceof Light) {
                    l = new Light(xGrid - i, yGrid, level, this);
                    beam.add(l);
                    level.spawner(l);
                }
                else if (entity.get() instanceof Mirror) {
                    if(((Mirror)entity.get()).mirrorShine(RIGHT))
                        mirrorHit = (Mirror) entity.get();
                    blocked = true;
                }
                else
                    blocked = true;
            }
            i++;
        }
    }

    @Override
    public void interact() {
        setStatus(!status);
    }
    @Override
    public void update(){
        if(status) {
            turnOff();
            turnOn();
        }
    }
}

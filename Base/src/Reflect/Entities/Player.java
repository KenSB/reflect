package Reflect.Entities;

import Reflect.States.Level;

import java.awt.*;
import java.util.Optional;

public class Player extends Entity implements Animatable{
    public Player(int xPos, int yPos, Level level) {
        super(xPos, yPos, level, true);
    }

    @Override
    public boolean collision(int direction, int distance) {
        Optional<Entity> entity = null;
        if(direction == UP){
            for(int i = 1; i <= distance; i++) {
                entity = level.getEntity(xGrid, yGrid - i);
                if (entity != null)
                    if (!(entity.get() instanceof Light))
                        return true;
            }
        }
        else if(direction == DOWN){
            for(int i = 1; i <= distance; i++) {
                entity = level.getEntity(xGrid, yGrid + i);
                if (entity != null)
                    if (!(entity.get() instanceof Light))
                        return true;
            }
        }
        else if(direction == RIGHT){
            for(int i = 1; i <= distance; i++) {
                entity = level.getEntity(xGrid + i, yGrid);
                if (entity != null)
                    if (!(entity.get() instanceof Light))
                        return true;
            }
        }
        else if(direction == LEFT){
            for(int i = 1; i <= distance; i++) {
                entity = level.getEntity(xGrid - i, yGrid);
                if (entity != null)
                    if (!(entity.get() instanceof Light))
                        return true;
            }
        }
        return false;
    }

    @Override
    public void move(int direction, int distance) {
        movingDirection = direction;
        if(!animate) {
            if (!collision(direction, distance))
                animate(direction, distance);
        }

    }
    @Override
    public void animate(int direction, int distance) {
        movingDistance = distance;
        animate = true;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        if(animate) {
            g.fill3DRect(xDraw, yDraw, 50, 50, true);
        }
        else{
            g.fill3DRect(xGrid*dimension, yGrid*dimension, 50, 50, true);
        }
    }

    public void interact(){
        Optional<Entity> entity;
        if(movingDirection == UP){
            entity = level.getEntity(xGrid,yGrid - 1);
            if(entity != null) {
                if (entity.get() instanceof Interactable)
                    ((Interactable) entity.get()).interact();
            }
        }
        else if(movingDirection == DOWN){
            entity = level.getEntity(xGrid,yGrid + 1);
            if(entity != null) {
                if (entity.get() instanceof Interactable)
                    ((Interactable) entity.get()).interact();
            }
        }
        else if(movingDirection == RIGHT){
            entity = level.getEntity(xGrid + 1,yGrid);
            if(entity != null) {
                if (entity.get() instanceof Interactable)
                    ((Interactable) entity.get()).interact();
            }
        }
        else if(movingDirection == LEFT){
            entity = level.getEntity(xGrid - 1,yGrid);
            if(entity != null) {
                if (entity.get() instanceof Interactable)
                    ((Interactable) entity.get()).interact();
            }
        }
    }

}

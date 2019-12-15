package Escape.Entities;
import Escape.States.Level;

import java.awt.*;
import java.util.Optional;

public class Player extends Entity implements Animatable{
    public Player(int xPos, int yPos, Level level) {
        super(xPos, yPos, level, true);
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

package Reflect.Entities;

import Reflect.States.State;

import java.awt.*;
import java.util.Iterator;

public class Player extends Entity implements Animatable{
    public Player(int xPos, int yPos, State stage) {
        super(xPos, yPos, stage, true);
    }

    @Override
    public boolean collision(int direction, int distance) {
        Entity entity;
        for (Iterator it = stage.getEntitiesIterator(); it.hasNext(); ) {
            entity = (Entity)it.next();
            if(direction == UP){
                for(int i = 1; i <= distance; i++)
                    if(yGrid - i == entity.getYPos() && xGrid == entity.getXPos())
                        return true;
            }
            else if(direction == DOWN){
                for(int i = 1; i <= distance; i++)
                    if(yGrid + i == entity.getYPos() && xGrid == entity.getXPos())
                        return true;
            }
            else if(direction == RIGHT){
                for(int i = 1; i <= distance; i++)
                    if(xGrid + i == entity.getXPos() && yGrid == entity.getYPos())
                        return true;
            }
            else if(direction == LEFT){
                for(int i = 1; i <= distance; i++)
                    if(xGrid - i == entity.getXPos() && yGrid == entity.getYPos())
                        return true;
            }
        }
        return false;
    }

    @Override
    public void move(int direction, int distance) {
        if(!animate)
            if(!collision(direction, distance))
                animate(direction, distance);
    }
    @Override
    public void animate(int direction, int distance) {
        movingDirection = direction;
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
}

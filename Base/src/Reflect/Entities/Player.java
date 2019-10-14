package Reflect.Entities;

import Reflect.States.State;

import java.awt.*;
import java.util.Iterator;

public class Player extends Entity implements Animatable{
    public Player(int xPos, int yPos, State stage) {
        super(xPos, yPos, stage);
    }

    @Override
    public boolean collision(int direction) {
        Entity entity;
        for (Iterator it = stage.getEntitiesIterator(); it.hasNext(); ) {
            entity = (Entity)it.next();
            if(direction == UP){
                if(yPos - 1 == entity.getYPos() && xPos == entity.getXPos())
                    return true;
            }
            else if(direction == DOWN){
                if(yPos + 1 == entity.getYPos() && xPos == entity.getXPos())
                    return true;
            }
            else if(direction == RIGHT){
                if(xPos + 1 == entity.getXPos() && yPos == entity.getYPos())
                    return true;
            }
            else if(direction == LEFT){
                if(xPos - 1 == entity.getXPos() && yPos == entity.getYPos())
                    return true;
            }
        }
        return false;
    }

    @Override
    public void move(int direction) {
        if(!collision(direction))
            changePos(direction);
    }

    private void changePos(int direction){
        if(direction == UP)
            yPos -= 1;
        else if(direction == DOWN)
            yPos += 1;
        else if(direction == RIGHT)
            xPos += 1;
        else if(direction == LEFT)
            xPos -= 1;
    }
    @Override
    public void animate() {
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fill3DRect(xPos*dimension, yPos*dimension, 50, 50, true);
    }
}

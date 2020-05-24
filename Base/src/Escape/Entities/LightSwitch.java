package Escape.Entities;
import Escape.States.Level;

import java.awt.*;
import java.util.Optional;

public class LightSwitch extends Entity{
    Interactable entity;
    private boolean status;

    public LightSwitch(int xGrid, int yGrid, Level level) {
        super(xGrid, yGrid, level, false);
        status = false;
    }

    private void setStatus() {
        this.status = checkHasLight();
    }

    private boolean checkHasLight(){
        Optional<Entity> entity;
        for(int direction = 1; direction <= 5; direction++) {
            if(direction == LEFT)
                entity = level.getEntity(xGrid - 1, yGrid);
            else if(direction == RIGHT)
                entity = level.getEntity(xGrid + 1,yGrid);
            else if(direction == UP)
                entity = level.getEntity(xGrid,yGrid - 1);
            else
                entity = level.getEntity(xGrid,yGrid + 1);
            if(entity != null) {
                if(entity.get() instanceof Light)
                    return true;
            }
        }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        setStatus();
        if(status)
            g.setColor(Color.RED);
        else
            g.setColor(Color.pink);
        if(animate) {
            g.fill3DRect(xDraw, yDraw, 50, 50, true);
        }
        else{
            g.fill3DRect(xGrid*dimension, yGrid*dimension, 50, 50, true);
        }
    }

    public boolean getStatus(){
        return status;
    }

    @Override
    public void animate(int direction, int distance) {

    }
}

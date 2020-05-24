package Escape.Entities;
import Escape.States.Level;

import java.awt.*;

public class Door extends Entity implements Linkable{
    LightSwitch controller;
    public Door(int xGrid, int yGrid, Level level) {
        super(xGrid, yGrid, level, false);
    }
    public void setController(LightSwitch controller){
        this.controller = controller;
    }

    @Override
    public void draw(Graphics g) {
        if(controller.getStatus())
            g.setColor(Color.black);
        else
            g.setColor(Color.YELLOW);
        if(animate) {
            g.fill3DRect(xDraw, yDraw, 50, 50, true);
        }
        else{
            g.fill3DRect(xGrid*dimension, yGrid*dimension, 50, 50, true);
        }

    }

    @Override
    public void animate(int direction, int distance) {

    }

    @Override
    public void link(Entity entity) {
        if(entity instanceof LightSwitch){
            setController((LightSwitch) entity);
        }
    }
}

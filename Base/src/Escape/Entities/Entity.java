package Escape.Entities;
import Escape.Drawable;
import Escape.States.Level;

import java.util.Optional;

public abstract class Entity implements Drawable, Animatable {
    final int UP = 1;
    final int DOWN = 2;
    final int RIGHT = 3;
    final int LEFT = 4;
    final int UPRIGHT = 5;
    final int UPLEFT = 6;
    final int DOWNRIGHT = 7;
    final int DOWNLEFT = 8;

    final int dimension = 50;

    int xGrid;
    int yGrid;
    int xDraw;
    int yDraw;
    Level level;

    EntityAnimationTimer animator;
    boolean animate = false;
    int movingDistance = 0;
    int movingDirection = 1;

    public Entity(int xGrid, int yGrid, Level level, boolean animate){
        this.xGrid = xGrid;
        this.yGrid = yGrid;
        this.level = level;
        if(animate) {
            animator = new EntityAnimationTimer(this, level.frame);
            animator.start();
        }
    }
    public boolean collision(int direction, int distance) {
        Optional<Entity> entity = null;
        if(direction == UP){
            for(int i = 1; i <= distance; i++) {
                entity = level.getEntity(xGrid, yGrid - i);
                if (entity != null) {
                    if(entity.get() instanceof Box) {
                        entity.get().move(UP, 1);
                        return true;
                    }
                    else if (!(entity.get() instanceof Light))
                        return true;
                }

            }
        }
        else if(direction == DOWN){
            for(int i = 1; i <= distance; i++) {
                entity = level.getEntity(xGrid, yGrid + i);
                if (entity != null) {
                    if(entity.get() instanceof Box) {
                        entity.get().move(DOWN, 1);
                        return true;
                    }
                    else if (!(entity.get() instanceof Light))
                        return true;
                }
            }
        }
        else if(direction == RIGHT){
            for(int i = 1; i <= distance; i++) {
                entity = level.getEntity(xGrid + i, yGrid);
                if (entity != null) {
                    if(entity.get() instanceof Box) {
                        entity.get().move(RIGHT, 1);
                        return true;
                    }
                    else if (!(entity.get() instanceof Light))
                        return true;
                }
            }
        }
        else if(direction == LEFT){
            for(int i = 1; i <= distance; i++) {
                entity = level.getEntity(xGrid - i, yGrid);
                if (entity != null) {
                    if(entity.get() instanceof Box) {
                        entity.get().move(LEFT, 1);
                        return true;
                    }
                    else if (!(entity.get() instanceof Light))
                        return true;
                }
            }
        }
        return false;
    }
    public void move(int direction, int distance) {
        movingDirection = direction;
        if(!animate) {
            if (!collision(direction, distance))
                animate(direction, distance);
        }
    }

    public int getXPos() {return xGrid;}
    public int getYPos() {return yGrid; }
    public boolean getAnimate(){return animate; }

    void changePos(int direction, int distance){
        if(direction == UP)
            yGrid -= distance;
        else if(direction == DOWN)
            yGrid += distance;
        else if(direction == RIGHT)
            xGrid += distance;
        else if(direction == LEFT)
            xGrid -= distance;
    }
}

package Reflect.Entities;
import Reflect.Drawable;
import Reflect.States.Level;

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
    public abstract boolean collision(int direction, int distance);
    public abstract void move(int direction, int distance);

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

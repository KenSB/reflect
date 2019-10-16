package Reflect.Entities;
import Reflect.Drawable;
import Reflect.States.State;

public abstract class Entity implements Drawable, Animatable {
    final int UP = 1;
    final int DOWN = 2;
    final int RIGHT = 3;
    final int LEFT = 4;
    final int dimension = 50;

    int xGrid;
    int yGrid;
    int xDraw;
    int yDraw;
    State stage;

    EntityAnimationTimer animator;
    boolean animate = false;
    int movingDistance = 0;
    int movingDirection = 0;

    public Entity(int xGrid, int yGrid, State stage, boolean animate){
        this.xGrid = xGrid;
        this.yGrid = yGrid;
        this.stage = stage;
        if(animate) {
            animator = new EntityAnimationTimer(this, stage.frame);
            animator.start();
        }
    }
    public abstract boolean collision(int direction, int distance);
    public abstract void move(int direction, int distance);

    public int getXPos() {return xGrid;}
    public int getYPos() {return yGrid; }

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

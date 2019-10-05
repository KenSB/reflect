package Reflect.Entities;
import Reflect.Drawable;

public abstract class Entity implements Drawable, Animatable {
    public int xPos;
    public int yPos;
    public final int UP = 1;
    public final int DOWN = 2;
    public final int RIGHT = 3;
    public final int LEFT = 4;

    public Entity(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public abstract void collision();
    public abstract void move();
}

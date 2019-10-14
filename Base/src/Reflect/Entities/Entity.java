package Reflect.Entities;
import Reflect.Drawable;
import Reflect.States.State;

public abstract class Entity implements Drawable, Animatable {
    final int UP = 1;
    final int DOWN = 2;
    final int RIGHT = 3;
    final int LEFT = 4;
    final int dimension = 50;

    int xPos;
    int yPos;
    State stage;
    public Entity(int xPos, int yPos, State stage){
        this.xPos = xPos;
        this.yPos = yPos;
        this.stage = stage;
    }
    public abstract boolean collision(int direction);
    public abstract void move(int direction);

    public int getXPos() {return xPos;}
    public int getYPos() {return yPos; }
}
